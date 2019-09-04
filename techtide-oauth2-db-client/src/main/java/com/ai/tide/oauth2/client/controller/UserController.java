package com.ai.tide.oauth2.client.controller;

import com.ai.tide.oauth2.client.domain.User;
import com.ai.tide.oauth2.client.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/4 12:03
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String showHello(){
        return "hello";
    }

    @RequestMapping("/register")
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        if(StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            return userService.create(username, password);
        }
        return null;
    }
}
