package com.ai.tide.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/26 17:09
 **/
public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("=========================== Post Zuul Filter ============================");
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().setCharacterEncoding("UTF-8");

        String respondString = ctx.getResponseBody();
        if(StringUtils.isEmpty(respondString)) {
            ctx.setResponseStatusCode(500);
            ctx.setResponseBody(respondString);
        }
        return null;
    }
}
