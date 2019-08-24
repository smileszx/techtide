package com.techtide.web.service;

import com.techtide.web.po.User;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/24 16:21
 **/
public interface UserService {

    int insert(User record);

    User listUser(Long id);
}
