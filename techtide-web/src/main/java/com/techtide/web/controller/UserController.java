package com.techtide.web.controller;

import com.github.pagehelper.PageInfo;
import com.techtide.web.po.User;
import com.techtide.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.techtide.spring.boot.autoconfigure.service.SomeService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/24 16:30
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private SomeService someService;

    @ApiOperation("测试自定义starter")
    @RequestMapping(value = "/test/{name}")
    public String testCustomStarter (@PathVariable("name") String name) {
        return someService.wrap(name);
    }

    @ApiOperation("新增用户")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String testInsert (@ApiParam("用户信息") @RequestBody User user) {
        int record = service.insert(user);
        return "insert: " + user + ", result: " + record;
    }
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public PageInfo<User> getUserById () {

        List<User> user = service.listUser();
        System.out.println(user);
        PageInfo<User> userPageInfo = new PageInfo<>(user);
        return userPageInfo;
    }


    /**
     * 分析Cookie文件
     * @param cookies
     * @return
     */
    private Map<String, String> getCookie(Cookie[] cookies) {
        if(cookies == null)
            return null;

        final Map<String, String> map = new HashMap<>();
        Arrays.stream(cookies).forEach(cookie -> map.put(cookie.getName(),cookie.getValue()));
        return map;
    }
}
