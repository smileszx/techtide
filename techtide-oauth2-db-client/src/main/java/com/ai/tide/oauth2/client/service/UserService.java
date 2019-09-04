package com.ai.tide.oauth2.client.service;

import com.ai.tide.oauth2.client.domain.User;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/4 12:04
 **/
public interface UserService {
    User create(String username, String password);
}
