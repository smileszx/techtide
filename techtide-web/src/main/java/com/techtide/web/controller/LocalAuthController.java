package com.techtide.web.controller;

import com.techtide.web.service.LocalAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/local")
@Api("登录退出等控制器")
public class LocalAuthController {

    @Autowired
    private LocalAuthService localAuthService;

    @GetMapping("/login")
    @ApiOperation("登录")
    private Map<String, Object> login(@ApiParam("用户名")@RequestParam String username,
                                      @ApiParam("密码")@RequestParam String password) {
        // 省略代码
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

}