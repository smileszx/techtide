package com.ai.tide.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * @Description
 * pre B
 * @Author victor su
 * @Date 2019/8/26 16:52
 **/
public class PreBFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean) ctx.get("logic-is-success");
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("=========================== pre B Zuul Filter ============================");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String b = request.getParameter("b");
        if(StringUtils.isEmpty(b)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("{\"status:\":500,\"message\":\"参数b为空\"}");
            ctx.set("logic-is-success", false);
            return null;
        }
        return null;
    }
}
