package com.mxz.mq.kafka;

/**
 * Created by MABIAO on 2017/3/31 0031.
 */
public interface KafkaProperties {

    final static String zkConnect = "192.168.5.206:2181";
    final static String groupId = "group1";
    final static String topic = "topic1";
    final static String kafkaServerURL = "192.168.5.206";
    final static int kafkaServerPort = 9092;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}
