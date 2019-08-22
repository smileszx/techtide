package com.ai.tide.test;

import org.junit.Test;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/22 16:36
 **/
public class WrapperTest {

    @Test
    public void testIntegerBoxing () {

        //Integer 介于-128 ~ 127 之间的int 自动装箱
        Integer a = -129;
        Integer b = -129;
        Integer a1 = new Integer(-129);
        Integer b1 = new Integer(-129);
        System.out.println(a == b);
        System.out.println(a == a1);
        System.out.println(a1 == b1);
        System.out.println(a == -129);
        System.out.println(a1 == -129);

        Integer n = 1;
        Double x = 2.0;
        System.out.println(true ? n : x); // Prints 1.0

    }
}
