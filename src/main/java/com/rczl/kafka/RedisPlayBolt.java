package com.rczl.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.rczl.kafka.msg.PlayMsgVO;
import com.rczl.kafka.util.JacksonUtil;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 */
public class RedisPlayBolt extends BaseRichBolt {
	private JedisPool pool;
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	private OutputCollector collector;
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
		//change "maxActive" -> "maxTotal" and "maxWait" -> "maxWaitMillis" in all examples
		JedisPoolConfig config = new JedisPoolConfig();
		//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
		config.setMaxIdle(5);
		//控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
		//如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
		//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
		config.setMaxTotal(1000 * 100);
		//表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
		config.setMaxWaitMillis(30);
		config.setTestOnBorrow(true);
		config.setTestOnReturn(true);
		/**
		 *如果你遇到 java.net.SocketTimeoutException: Read timed out exception的异常信息
		 *请尝试在构造JedisPool的时候设置自己的超时值. JedisPool默认的超时时间是2秒(单位毫秒)
		 */
		pool = new JedisPool(config, "10.10.1.63", 23308);
	}

	@Override
	public void execute(Tuple input) {
	
		//获取kafkaSpout发送过来的数据，是一个json
		String stringStr = new String((byte[]) input.getValue(0));
		if(StringUtils.isBlank(stringStr)) {
			return;
		}
		Jedis jedis = pool.getResource();
		//解析json
		PlayMsgVO playMsgVO =	JacksonUtil.readValue(stringStr, PlayMsgVO.class);
		Date StartPlayTime=       playMsgVO.getPlayInfo().getStartPlayTime();
		Date endPlayTime=    playMsgVO.getPlayInfo().getEndPlayTime();
		//秒数
		double timeSec=     (endPlayTime.getTime()  -   StartPlayTime.getTime()) / 1000;
		if(timeSec > 86400 || timeSec <=0) { //观看时间大于1天为异常数据
			timeSec = 0;
		}else {
			timeSec = timeSec/60;
		}
		/*else {
			BigDecimal b = new BigDecimal(timeSec/60);
			timeSec = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		}*/

		if(playMsgVO.getPlayInfo().getVodInfo() != null && timeSec != 0) {
			Long mediaId=	playMsgVO.getPlayInfo().getVodInfo().getMediaId();
			String mediaName = playMsgVO.getPlayInfo().getVodInfo().getMediaName();
			Long columnId =playMsgVO.getPlayInfo().getVodInfo().getColumnId();
			//播放次数统计
			jedis.zincrby("VodTotal:"+df.format(new Date())+":"+columnId, 1L, mediaName);
			//播放总时间统计
				jedis.zincrby("VodTotalTime:"+df.format(new Date())+":"+columnId,timeSec , mediaName);
				//点播数据进入下一层bolt,根据媒资id分类,暂时只分析电影columnId == 3
				if(columnId == 3) {
					collector.emit(new Values(mediaId,playMsgVO));
				}
		}else if(playMsgVO.getPlayInfo().getLiveInfo() != null && timeSec != 0) {
			String  channelName=  	 playMsgVO.getPlayInfo().getLiveInfo().getChannelName();
	//		Integer channelId=    playMsgVO.getPlayInfo().getLiveInfo().getChannelId();
				jedis.zincrby("LiveTotalTime:"+df.format(new Date()), timeSec, channelName);
		}
		jedis.close();
	}


	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		  declarer.declare(new Fields("mediaId","playMsgVO"));
	}
}
