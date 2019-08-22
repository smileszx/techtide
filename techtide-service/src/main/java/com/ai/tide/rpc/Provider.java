package com.ai.tide.rpc;

import org.apache.dubbo.container.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/provider.xml");
//        context.start();
//        System.in.read(); // 按任意键退出

        Main.main(args);
    }
}