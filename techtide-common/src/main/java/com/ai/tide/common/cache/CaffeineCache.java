package com.ai.tide.common.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.stats.CacheStats;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/20 19:31
 **/
public class CaffeineCache {

    public static void main(String[] args) {
        Cache<Object, Object> caffeine = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .maximumSize(10)
                .recordStats()
                .build();
        caffeine.put("hello","hello");

        System.out.println(caffeine.getIfPresent("hello"));

        CacheStats stats = caffeine.stats();

        System.out.println(stats);
    }
}
