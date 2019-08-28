package com.ai.tide.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}
