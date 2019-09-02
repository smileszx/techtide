package com.techtide.web.config;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//异常：java.lang.NoSuchMethodException: tk.mybatis.mapper.provider.base.BaseSelectProvider.<init>()
// tk.mybatis导入包
import tk.mybatis.spring.annotation.MapperScan;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.techtide.web.dao")
public class MyBatisConfig {
}
