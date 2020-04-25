package com.julius.base.gateway.config;

import com.julius.base.gateway.filter.CustomPostZuulFilter;
import com.julius.base.gateway.filter.CustomPreZuulFilter;
import com.julius.base.gateway.filter.CustomRouteZuulFilter;
import com.julius.base.gateway.route.CustomRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: com.julius.base.gateway.config
 * @ClassName: CustomZuulConfiguration
 * @Author: Julius
 * @Description: 自定义zuul路由配置类
 * @Date: 2020/1/18 16:24
 * @Version: 1.0
 */
@Configuration
public class CustomZuulConfiguration {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public CustomRouteLocator customRouteLocator(){
        return new CustomRouteLocator(this.zuulProperties.getServletPath(),this.zuulProperties);
    }

    @Bean
    public CustomPreZuulFilter customPreZuulFilter(){
        return new CustomPreZuulFilter();
    }

    @Bean
    public CustomPostZuulFilter customPostZuulFilter(){
        return new CustomPostZuulFilter();
    }

    @Bean
    public CustomRouteZuulFilter customRouteZuulFilter(){
        return new CustomRouteZuulFilter();
    }


}
