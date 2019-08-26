package com.ai.tide.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @Description
 * 自定义ZuulFilter实现
 * @Author victor su
 * @Date 2019/8/26 16:18
 **/
public class CustomFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //设定Filter类型，可以设置pre、route、post、error类型
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //设定执行次序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //设定该Filter是否执行，可以作为开关使用
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //Filter的核心执行逻辑，业务处理在此编写
        System.out.println("=============== Hello world, this is a first custom Zuul Filter. ====================");
        return null;
    }
}
