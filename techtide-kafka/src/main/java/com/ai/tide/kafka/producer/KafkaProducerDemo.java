package com.ai.tide.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @Description
 * Kafka 消息生产者
 * @Author victor su
 * @Date 2019/9/9 18:48
 **/
public class KafkaProducerDemo {


    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.1.101:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<String, String>("my-topic", Integer.toString(i), Integer.toString(i)), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if(exception != null) {
                        System.out.println(exception.getMessage());
                        exception.printStackTrace();
                    } else {
                        System.out.println("=======> offset: " + metadata.offset() + ", partition: " + metadata.partition()
                                + ", topic: " + metadata.topic() + ", metadata:" + metadata.toString());
                    }
                }
            });

        producer.close();

    }

}
