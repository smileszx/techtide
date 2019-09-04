package com.ai.pay.test;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/4 22:10
 **/
public final class FinalClassDemo implements Cloneable{

    private final String name = "FinalClassDemo";

    public String getName() {
        return name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
