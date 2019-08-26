package com.ai.tide.zuul.filter;

import com.ai.tide.zuul.util.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @Description
 * 自定义权限认证 Filter
 * @Author victor su
 * @Date 2019/8/26 19:01
 **/
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String userId = CookieUtil.getValue(request, "userName");
        if(StringUtils.isEmpty(userId))
            System.out.println("userName is null");
        if(userId.equals("zhengxiao")) {
            System.out.println("=================登陆成功===================");
        }
        return null;
    }
}
