import com.ai.pay.test.FinalClassDemo;
import org.junit.Test;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/4 20:50
 **/
public class WhatIsObject {

    private Object object = new Object();

    @Test
    public void testGetClass() {
        Class clazz = object.getClass();

        String s = new String();

        Class sClazz = s.getClass();

        System.out.println(clazz);

        FinalClassDemo demo = new FinalClassDemo();

        try {
            FinalClassDemo cloneDemo = (FinalClassDemo) demo.clone();

            System.out.println(cloneDemo.getClass() + " " + cloneDemo.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
