package com.ai.tide.oauth2.client.service.impl;

import com.ai.tide.oauth2.client.domain.User;
import com.ai.tide.oauth2.client.mapper.UserMapper;
import com.ai.tide.oauth2.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/4 12:05
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(password));
        userMapper.insertSelective(user);
        return user;
    }
}
