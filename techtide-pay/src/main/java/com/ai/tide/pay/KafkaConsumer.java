package com.ai.tide.pay;

import com.ai.tide.api.service.DemoService;
import com.ai.tide.api.service.PaymentService;
import com.ai.tide.pay.kafka.KafkaSendMessageServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KafkaConsumer {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/kafka-consumer.xml");
        context.start();
    }
}