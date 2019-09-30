package com.ai.tide.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @Description
 * Zipkin 启动类
 * @Author victor su
 * @Date 2019/9/30 21:49
 **/
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipkinServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
