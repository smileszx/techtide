package org.techtide.spring.boot.autoconfigure.service;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/29 11:59
 **/

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 该类用于封装从配置文件中读取的属性值
 */
@Data
@ConfigurationProperties("some.service")
public class SomeServiceProperties {
    // 对应配置文件中的some.service.before属性
    private String before;

    // 对应配置文件中的some.service.after属性
    private String after;
}