package com.techtide.web.filter;

/**
 * 审批者类：抽象处理者
 * Web应用开发中创建一个过滤器(Filter)链来对请求数据进行过滤，
 * 在工作流系统中实现公文的分级审批等等，使用职责链模式可以较好地解决此类问题
 */
public abstract class ApproverHandler {

    //定义后继对象，类似链表
    protected ApproverHandler successor;

    //审批者姓名
    protected String name;

    //抽象类也是类，只不过本身不能实例化，要通过子类实例化。
    public ApproverHandler (String name) {
        this.name = name;
    }

    //设置后继审批者
    public void setSuccessor(ApproverHandler successor) {
        this.successor = successor;
    }
    //抽象请求处理方法
    public abstract void processRequestHandler(PurchaseRequest request);
}
