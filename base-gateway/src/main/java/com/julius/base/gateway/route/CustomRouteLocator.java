package com.julius.base.gateway.route;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.model.HealthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Package: com.julius.base.gateway.route
 * @ClassName: CustomRouteLocator
 * @Author: Julius
 * @Description: 自定义路由探测器
 * 基于配置文件配置智能路由和服务注册与发现实现动态路由，通过实现接口RefreshableRouteLocator实现路由的动态刷新
 * 重写方法locateRoutes：
 *  1、解析从配置文件中获取到的路由信息
 *  2、解析从注册中心中获取到的路由服务信息
 *  3、整合智能路由信息
 * @Date: 2020/1/18 16:28
 * @Version: 1.0
 */
public class CustomRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator {

    private static final Logger log = LoggerFactory.getLogger(CustomRouteLocator.class);

    private ZuulProperties zuulProperties;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ConsulClient consulClient;


    /**
     * @param servletPath
     * @param properties
     */
    public CustomRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.zuulProperties = properties;
    }

    @Override
    public void refresh() {
        /**
         * @Todo 动态刷新路由
         */
    }

    //覆写locateRoutes

    protected LinkedHashMap<String,ZuulProperties.ZuulRoute> locateRoutes(){
        LinkedHashMap<String,ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>(1<<4);
        //将配置文件中的智能路由全部加入
        routesMap.putAll(super.locateRoutes());
        LinkedHashMap values = null;
        Iterator var3;
        String path;
        if(this.discoveryClient != null){
            values = new LinkedHashMap(1<<4);
            //将routesMap复制到values，并转为Iterator
            var3 = routesMap.values().iterator();
            //循环所有路由
            while (var3.hasNext()){
                ZuulProperties.ZuulRoute route = (ZuulProperties.ZuulRoute) var3.next();
                path = route.getServiceId();
                if(path == null){
                    path =  route.getId();
                }else{
                    values.put(path,route);
                }
                //通过服务发现从注册中心获取服务列表
                List<String> services = this.getServices();
                //todo 处理服务注册中心的服务列表





            }
        }
        return values;
    }

    /**
     * @Description 获取服务中心的服务列表
     * @return String === serviceId
     */
    public List<String> getServices() {
        List<String> serviceNames = this.discoveryClient.getServices();
        log.info("discoveryClient service list:{}",serviceNames.toString());
        List<String> services;
        if(this.consulClient != null){
            for(String serviceName : serviceNames){
                log.info("discoveryClient service name :{}",serviceName);
                if(StringUtils.isEmpty(serviceName)){
                    continue;
                }
                services = new ArrayList<>();
                //获取对象服务名称的节点
                Response response = consulClient.getHealthServices(serviceName,false,null);
                if(response == null){
                    continue;
                }
                List<HealthService> healthServices = (List<HealthService>) response.getValue();
                if(ObjectUtils.isEmpty(healthServices)){
                    continue;
                }
                log.info("consul client service list:{}",healthServices.toString());
            }
        }
        return serviceNames;
    }

}
