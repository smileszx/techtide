package com.techtide.web.service;

import com.techtide.web.dao.UserMapper;
import com.techtide.web.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/24 16:22
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public List<User> listUser() {
        return userMapper.selectAll();
    }
}
