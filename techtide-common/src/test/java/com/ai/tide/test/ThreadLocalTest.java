package com.ai.tide.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/23 10:12
 **/
public class ThreadLocalTest {
    private static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(
            ()->new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    @Test
    public void testThreadLocal () throws InterruptedException {
        System.out.println(dateFormat.get());

        for(int i=0; i<10; i++) {
            Thread thread = new Thread(()->{
                try {
                    Thread.sleep((long) (ThreadLocalRandom.current().nextInt(10) * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String date = dateFormat.get().format(new Date());
                System.out.println(Thread.currentThread().getName() + " " + date);
            },"thread-" + i);
            thread.start();
        }

        Thread.currentThread().join();

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(2);
    }


}
