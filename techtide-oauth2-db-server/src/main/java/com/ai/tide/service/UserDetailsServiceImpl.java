package com.ai.tide.service;

import com.ai.tide.domain.User;
import com.ai.tide.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/9/3 22:47
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //创建example对象
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        List<User> users = userMapper.selectByExample(example);
        User user = null;
        //判断
        if(users!=null && users.size()>0){
            user = users.get(0);
        }
        return user;
    }
}
