package com.techtide.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * Redis Cluster 集群
 * @Author victor su
 * @Date 2019/9/25 16:08
 **/
@RestController
@RequestMapping("/redis")
public class RedisClusterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClusterController.class);

    @Autowired
    private static RedisConnectionFactory connectionFactory;

    @RequestMapping("/cache")
    public String findCache() {
        RedisClusterConnection redisClusterConnection =connectionFactory.getClusterConnection();

        Boolean result = redisClusterConnection.set("panda".getBytes(), "sichuan".getBytes());

        LOGGER.debug("新增缓存：" + result + redisClusterConnection.get("panda".getBytes()));
        return redisClusterConnection.get("panda".getBytes())+"";
    }
}
