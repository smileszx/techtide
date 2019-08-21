package com.techtide.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/20 22:38
 **/
@SpringBootApplication
@EnableEurekaServer
public class TechTideApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechTideApplication.class, args);
    }

}
