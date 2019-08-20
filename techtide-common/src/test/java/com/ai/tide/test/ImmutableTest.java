package com.ai.tide.test;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/20 19:45
 **/
public class ImmutableTest {

    @Test
    public void testImmutableSet() {
        ImmutableItem immutableItem = new ImmutableItem();
        System.out.println(immutableItem.getCount());
    }


    @Immutable
    class ImmutableItem {
        private final Integer count = 0;

        public  Integer getCount() {
            return count;
        }

    }

}
