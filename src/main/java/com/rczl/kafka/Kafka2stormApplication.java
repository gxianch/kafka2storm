package com.rczl.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.ZkHosts;
@RestController
@SpringBootApplication
public class Kafka2stormApplication implements CommandLineRunner {
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Kafka2stormApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		 TopologyBuilder topologyBuilder = new TopologyBuilder();
	        topologyBuilder.setSpout("kafkaSpout",
	                new KafkaSpout(new SpoutConfig(
	                        new ZkHosts("10.10.1.110:2181,10.10.1.111:2181,10.10.1.112:2181"),
	                        "play",
	                        "/myKafka",
	                        "kafkaSpout")),1);
	        topologyBuilder.setBolt("redisbolt",new RedisPlayBolt(),1).shuffleGrouping("kafkaSpout");
	        //根据媒资id进行分组
	        topologyBuilder.setBolt("mediabolt", new MediaPlayBolt(),1).fieldsGrouping("redisbolt", new Fields("mediaId"));
	        Config config = new Config();
	        config.setNumWorkers(1);

	        //3、提交任务  -----两种模式 本地模式和集群模式
	        if (args.length>0) {
	            StormSubmitter.submitTopology(args[0], config, topologyBuilder.createTopology());
	        }else {
	            LocalCluster localCluster = new LocalCluster();
	            localCluster.submitTopology("storm2kafka", config, topologyBuilder.createTopology());
	        }
		
	}

	
}
