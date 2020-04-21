package com.julius.base.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package: com.julius.base.gateway.filter
 * @ClassName: CustomPreZuulFilter
 * @Author: Julius
 * @Description: 自定义Pre类型过滤器
 * @Date: 2020/4/21 19:30
 * @Version: 1.0
 */
public class CustomPreZuulFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(CustomPreZuulFilter.class);



    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //校验
        String accessToken = request.getHeader("accessToken");

        if(StringUtils.isEmpty(accessToken)){
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false);
            log.warn("token check is failed,{}",accessToken);
            return null;
        }

        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);

        log.info("token check is successful,{}",accessToken);
        return null;
    }
}
