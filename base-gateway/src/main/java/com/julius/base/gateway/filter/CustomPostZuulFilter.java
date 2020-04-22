package com.julius.base.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Package: com.julius.base.gateway.filter
 * @ClassName: CustomPostZuulFilter
 * @Author: Julius
 * @Description: 自定义post类型的过滤器
 * @Date: 2020/4/22 9:29
 * @Version: 1.0
 */
public class CustomPostZuulFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(CustomPostZuulFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        log.info("This is a post type");
        RequestContext ctx = RequestContext.getCurrentContext();
        //判断此时请求有响应并且没有发生异常
        if(ctx.getThrowable() == null &&(ctx.getResponseDataStream()!=null || ctx.getResponseBody() != null)){
            HttpServletResponse response = ctx.getResponse();
            //todo 处理响应结果
            String body = ctx.getResponseBody();

            InputStream is = ctx.getResponseDataStream();

            log.info("ctx body :{}",body);
            log.info("ctx inputStream :{}",is);
        }
        return null;
    }
}
