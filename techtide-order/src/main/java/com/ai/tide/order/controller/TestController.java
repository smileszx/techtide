package com.ai.tide.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/26 12:48
 **/
@RestController
public class TestController {

    @GetMapping("/add")
    public Integer test(Integer a, Integer b,
                        HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(new Cookie("userName", "zhengxiao"));
        response.addCookie(new Cookie("userAge", "30"));
        return a + b;
    }

    @RequestMapping("/test")
    public String testAuth (HttpServletRequest request) {
        System.out.println("========================== Header ===========================");
        Enumeration headNames = request.getHeaderNames();
        while (headNames.hasMoreElements()) {
            String key = (String) headNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        System.out.println("========================== Header ===========================");

        return "hellooooooooooooooooooooooooooooooooooooooo!";
    }
}
