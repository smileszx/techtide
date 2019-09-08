package com.ai.tide.pay.strategy;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/8 23:20
 **/
public class Client {
    public static void main(String[] args) {
        PayContext context = new PayContext(new WechatServiceImpl());

        context.pay();
    }
}
