package com.techtide.web.filter;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/29 9:28
 **/
public class VicePresidentHandler extends ApproverHandler {
    private static final double THRESHOLD_AMOUNT = 100000;

    public VicePresidentHandler(String name) {
        super(name);
    }

    @Override
    public void processRequestHandler(PurchaseRequest request) {
        if(request.getAmount() < THRESHOLD_AMOUNT) {
            System.out.println("副董事长" + this.name + "审批采购单: " + request);
        } else {
            //超出审批权限，转发审批权
            this.successor.processRequestHandler(request);
        }
    }
}
