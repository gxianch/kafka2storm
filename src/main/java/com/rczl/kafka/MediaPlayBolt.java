package com.rczl.kafka;

import java.util.Map;

import com.rczl.kafka.msg.PlayMsgVO;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

public class MediaPlayBolt extends BaseRichBolt {

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Tuple input) {
		long mediaId=	input.getLongByField("mediaId");
//		PlayMsgVO playMsgVO=	(PlayMsgVO) input.getValueByField("playMsgVO");
		System.out.println(mediaId);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}
