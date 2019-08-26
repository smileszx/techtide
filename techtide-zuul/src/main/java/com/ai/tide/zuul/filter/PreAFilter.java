package com.ai.tide.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @Description
 * pre A
 * @Author victor su
 * @Date 2019/8/26 16:51
 **/
public class PreAFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("=========================== pre A Zuul Filter ============================");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String a = request.getParameter("a");
        if(StringUtils.isEmpty(a)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("{\"status:\":500,\"message\":\"参数a为空\"}");
            ctx.set("logic-is-success", false);
            return null;
        }
        ctx.set("logic-is-success", true);
        return null;
    }
}
