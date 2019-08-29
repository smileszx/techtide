package com.techtide.web.filter;

/**
 * @Description
 * 主任类：审批者
 * @Author victor su
 * @Date 2019/8/29 9:21
 **/
public class DirectorHandler extends ApproverHandler {
    private static final double THRESHOLD_AMOUNT = 50000;

    //继承注意：子类不能继承父类的构造方法，但是可以通过super关键字去访问父类
    public DirectorHandler (String name) {
        super(name);
    }
    @Override
    public void processRequestHandler(PurchaseRequest request) {
        if(request.getAmount() < THRESHOLD_AMOUNT) {
            System.out.println("主任" + this.name + "审批采购单: " + request);
        } else {
            //超出审批权限，转发审批权
            this.successor.processRequestHandler(request);
        }
    }
}
