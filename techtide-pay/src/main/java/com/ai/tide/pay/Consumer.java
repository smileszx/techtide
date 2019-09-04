package com.ai.tide.pay;

import com.ai.tide.api.service.DemoService;
import com.ai.tide.api.service.PaymentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/consumer.xml");
        context.start();
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("world"); // 执行远程方法
        System.out.println( hello ); // 显示调用结果

        PaymentService paymentService = (PaymentService) context.getBean("paymentService");
        String pay = paymentService.pay("支付宝");
        System.out.println(pay);
    }
}