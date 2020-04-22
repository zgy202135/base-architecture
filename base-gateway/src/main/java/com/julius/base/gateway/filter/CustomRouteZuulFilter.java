package com.julius.base.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.julius.base.gateway.filter
 * @ClassName: CustomRouteZuulFilter
 * @Author: Julius
 * @Description: 自定义route类型过滤器，路由转发时调用
 * @Date: 2020/4/22 9:21
 * @Version: 1.0
 */
public class CustomRouteZuulFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(CustomPreZuulFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
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
        RequestContext ctx = RequestContext.getCurrentContext();
        //验证请求头信息是否过滤掉

        HttpServletRequest request = ctx.getRequest();
        return null;
    }
}
