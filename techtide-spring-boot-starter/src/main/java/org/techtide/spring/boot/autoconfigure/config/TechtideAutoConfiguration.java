package org.techtide.spring.boot.autoconfigure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.techtide.spring.boot.autoconfigure.service.SomeService;
import org.techtide.spring.boot.autoconfigure.service.SomeServiceProperties;

/**
 * @Description
 * 自定义starter
 * @Author victor su
 * @Date 2019/8/29 11:48
 **/
@Configuration
// 只有当前类路径下存在SomeService类时才会启用当前的JavaConfig配置类
@ConditionalOnClass(SomeService.class)
// 指定配置文件中指定属性的封装类
@EnableConfigurationProperties(SomeServiceProperties.class)
public class TechtideAutoConfiguration {

    @Autowired
    private SomeServiceProperties properties;

    // 以下两个方法的顺序不能颠倒
    @Bean
    @ConditionalOnProperty(name="some.service.enable", havingValue = "true", matchIfMissing = true)
    public SomeService someService() {
        return new SomeService(properties.getBefore(), properties.getAfter());
    }

    @Bean
    @ConditionalOnMissingBean
    public SomeService someService2() {
        return new SomeService("", "");
    }
}
