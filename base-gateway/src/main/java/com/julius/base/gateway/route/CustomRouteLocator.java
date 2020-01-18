package com.julius.base.gateway.route;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.model.HealthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Package: com.julius.base.gateway.route
 * @ClassName: CustomRouteLocator
 * @Author: Julius
 * @Description: 自定义路由探测器
 * 基于配置文件配置智能路由和服务注册与发现实现动态路由，通过实现接口RefreshableRouteLocator实现路由的动态刷新
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
    }

    @Override
    public void refresh() {
        /**
         * @Todo 动态刷新路由
         */
    }

    //覆写locateRoutes

    protected Map<String,ZuulProperties.ZuulRoute> locateRoutes(){
        LinkedHashMap<String,ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>(1<<4);
        //将配置文件中的智能路由全部加入
        routesMap.putAll(super.locateRoutes());
        LinkedHashMap values;
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

            }
        }

    }

    /**
     * @Description 获取服务中心的服务列表
     * @return String === serviceId
     */
    protected List<String> getServices() {
        List<String> serviceNames = this.discoveryClient.getServices();
        List<String> services;
        if(this.consulClient != null){
            //todo 判断服务的有效性和健康性
            for(String serviceName : serviceNames){
                if(StringUtils.isEmpty(serviceName)){
                    continue;
                }
                services = new ArrayList<>();
                Response response = consulClient.getHealthServices(serviceName,true,null);
                if(response == null){
                    continue;
                }
                List<HealthService> healthServices = (List<HealthService>) response.getValue();
                if(healthServices == null){
                    continue;
                }

            }
        }

    }

}
