package com.julius.base.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
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


}
