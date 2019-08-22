package com.ai.tide.rpc.provider;

import com.ai.tide.api.service.PaymentService;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/22 17:36
 **/
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String pay(String type) {
        System.out.println("支付方式: " + type);
        return "支付方式: " + type;
    }
}
