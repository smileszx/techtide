package org.techtide.spring.boot.autoconfigure.service;

import lombok.AllArgsConstructor;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/29 11:56
 **/
@AllArgsConstructor
public class SomeService {
    private String prefix;
    private String surfix;
    //自定义starter的核心功能实现
    public String wrap(String word) {
        return prefix + word + surfix;
    }
}
