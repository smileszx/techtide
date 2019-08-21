//package com.ai.tide.test;
//
//import com.ai.tide.common.exception.TideMQException;
//import com.ai.tide.common.rocketmq.TideMQProducer;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * @Description TODO
// * @Author victor su
// * @Date 2019/8/12 16:43
// **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-rocketmq-producer.xml")
//public class RocketMQProducerTest {
//
//    @Autowired
//    private TideMQProducer producer;
//
//    @Test
//    public void testMQProducer () throws TideMQException {
//
//
//        /**
//         * TODO：遗留问题，测试失败，可能原因如下
//         * 1. 发送超时
//         * 2. 路由不到broker
//         * 3. 服务器端启动内存不足
//         */
//
//        SendResult sendResult = this.producer.sendMessage("broker-a", "TagA", "OrderID188", "Hello world", 10000);
//
//        System.out.println(sendResult);
//    }
//
//
//
//}
