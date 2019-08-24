package com.techtide.web.controller;

import com.techtide.web.po.User;
import com.techtide.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
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

    @ApiOperation("新增用户")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String testInsert (@ApiParam("用户信息") @RequestBody User user) {
        int record = service.insert(user);
        return "insert: " + user + ", result: " + record;
    }
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUserById (@ApiParam("用户ID") @RequestParam("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Map<String, String> map = getCookie(cookies);
        System.out.println(map);

        String userName = map.get("userName");
        String userAge = map.get("userAge");

        if(userName == null) {
            response.addCookie(new Cookie("userName", "zhengxiao"));
        }

        if(userAge == null) {
            response.addCookie(new Cookie("userAge", "30"));
        }

        HttpSession session1 = request.getSession();
        System.out.println("request session: " + session1.getId());

        HttpSession session2 = request.getSession();
        System.out.println("response session: " + session2.getId());

        return service.listUser(id) + " Set-Cookie: " + response.getHeaders("Set-Cookie");
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
