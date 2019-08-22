package com.ai.tide.test;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/22 19:55
 **/
public class ReflectTest {

    @Test
    public void testForName () {
        String clazzName = "java.util.Random";

        try {
            Class clazz = Class.forName(clazzName);
            System.out.println(clazz.getName());

            Method[] methods = clazz.getDeclaredMethods();

            Random obj = (Random) clazz.newInstance();

            for(Method method : methods) {
                System.out.println(method.getName());
            }

            System.out.println(obj.nextInt());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetClass () {
        Class clazz1 = Random.class;
        Class clazz2 = int.class;
        Class clazz3 = Double[].class;

        System.out.println(clazz1.getName());
        System.out.println(clazz2.getName());
        System.out.println(clazz3.getName());

        System.out.println(clazz1.getModifiers());
        System.out.println(clazz1.getDeclaredMethods()[0].getModifiers());
    }
}
