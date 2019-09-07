package com.ai.tide.pay;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KafkaConsumer {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/kafka-consumer.xml");
        context.start();
    }
}