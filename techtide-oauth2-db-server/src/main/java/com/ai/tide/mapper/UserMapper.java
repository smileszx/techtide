package com.ai.tide.mapper;

import com.ai.tide.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description
 *
 * @Author victor su
 * @Date 2019/9/3 22:45
 **/
@org.apache.ibatis.annotations.Mapper
@Repository
public interface UserMapper extends Mapper<User> {
}
