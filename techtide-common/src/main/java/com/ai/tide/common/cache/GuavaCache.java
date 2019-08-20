package com.ai.tide.common.cache;

import com.google.common.cache.*;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * 利用Guava库创建本地缓存
 * @Author victor su
 * @Date 2019/8/20 17:37
 **/
public class GuavaCache {

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(Duration.ofSeconds(10))
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .recordStats()
                .build();

        cache.put("su", "zhengxiao");
        cache.put("a", "zhengxiao");
        cache.put("b", "zhengxiao");
        cache.put("c", "zhengxiao");
        cache.put("d", "zhengxiao");
        cache.put("e", "zhengxiao");
        cache.put("f", "zhengxiao");
        cache.put("g", "zhengxiao");
        cache.put("h", "zhengxiao");
        cache.put("i", "zhengxiao");
//        cache.put("j", "zhengxiao");

        String value = cache.getIfPresent("su");
        cache.getIfPresent("su");
        cache.getIfPresent("su");
        cache.getIfPresent("su");

        System.out.println(value);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String reload = cache.getIfPresent("su");
        System.out.println(reload);


        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return "" + key.hashCode();
                    }
                });
        String loading = null;
        try {
            loading = loadingCache.get("su");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(loading);

        System.out.println("缓存数：" + cache.size());

        CacheStats stats = cache.stats();
        System.out.println(String.join("_", "命中次数:" + stats.hitCount(), "命中率:"+stats.hitRate(), "未命中次数:"+stats.missCount(), "未命中率:"+stats.missRate()+""));




    }























}
