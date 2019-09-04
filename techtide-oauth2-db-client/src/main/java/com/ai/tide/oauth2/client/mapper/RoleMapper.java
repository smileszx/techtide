package com.ai.tide.oauth2.client.mapper;

import com.ai.tide.oauth2.client.domain.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Description
 *
 * @Author victor su
 * @Date 2019/9/3 23:20
 **/
@org.apache.ibatis.annotations.Mapper
@Repository
public interface RoleMapper extends Mapper<Role> {

}
