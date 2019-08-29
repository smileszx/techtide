package com.techtide.web.filter;

/**
 * @Description
 * 测试审批流程
 * @Author victor su
 * @Date 2019/8/29 9:35
 **/
public class Client {
    public static void main(String[] args) {

        // 审批者的初始化
        ApproverHandler director, vp, president,congress;
        director = new DirectorHandler("张无忌");
        vp = new VicePresidentHandler("谢逊");
        president = new PresidentHandler("张翠山");
        congress = new CongressHandler("武林大会");


        //创建审批流程,纯的职责链模式
        director.setSuccessor(vp);
        vp.setSuccessor(president);
        president.setSuccessor(congress);

        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");
        director.processRequestHandler(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
        director.processRequestHandler(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
        director.processRequestHandler(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
        director.processRequestHandler(pr4);
    }
}
