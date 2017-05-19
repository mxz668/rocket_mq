package com.mxz.mq.kafka;

/**
 * Created by MABIAO on 2017/3/31 0031.
 */
public class KafkaConsumerProducerDemo {

    public static void main(String[] args)
    {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        producerThread.start();

        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.run();
    }
}
