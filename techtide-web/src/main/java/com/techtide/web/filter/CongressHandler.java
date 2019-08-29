package com.techtide.web.filter;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/29 9:31
 **/
public class CongressHandler extends ApproverHandler {
    public CongressHandler(String name) {
        super(name);
    }
    @Override
    public void processRequestHandler(PurchaseRequest request) {
        System.out.println("采购金额过大，需召开董事会审批采购单: " + request.getAmount());
    }
}
