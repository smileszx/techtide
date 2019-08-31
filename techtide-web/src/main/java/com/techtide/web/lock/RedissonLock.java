package com.techtide.web.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/31 23:15
 **/
public class RedissonLock {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setTimeout(1000000)
                .setAddress("redis://192.168.1.102:6379");
        RedissonClient redisson = Redisson.create(config);
        RLock rLock = redisson.getFairLock("distribute");

        try {
            // 1. 最常见的使用方法
            // lock.lock();
            // 2. 支持过期解锁功能,10秒钟以后自动解锁, 无需调用unlock方法手动解锁
            // lock.lock(10, TimeUnit.SECONDS);
            // 3. 尝试加锁，最多等待3秒，上锁以后10秒自动解锁
            boolean res = rLock.tryLock(3, 100, TimeUnit.SECONDS);
            if (res) { // 成功
                // do your business
                System.out.println("获取到分布式锁： " + res);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rLock.unlock();
        }
    }

}
