package com.techtide.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Description
 * Redis Session缓存
 * @Author victor su
 * @Date 2019/8/23 18:24
 **/
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
