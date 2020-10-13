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

    /**
     * 当某个路由重连或者宕机时，动态刷新路由，以保证整体服务的可用性
     * todo 刷新机制
     */
    @Override
    public void refresh() {
        //调用了子类实现的locateRoutes
        this.doRefresh();
    }

    /**
     * 覆写locateRoutes
     * @return
     */
    protected LinkedHashMap<String,ZuulProperties.ZuulRoute> locateRoutes(){
        log.info("------------------加载路由---------------------");
        LinkedHashMap<String,ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>(1<<4);
        //将配置文件中的静态路由加入
        routesMap.putAll(super.locateRoutes());
        LinkedHashMap values = null;
        Iterator var3;
        String path;
        //处理服务中心的健康服务
        routesMap.putAll(this.getServiceRoute());
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
                }
                if(!path.startsWith("/")){
                    path = "/"+path;
                }
                //配置了前缀
                if(StringUtils.hasText(this.zuulProperties.getPrefix())){
                    path = this.zuulProperties.getPrefix()+path;
                    if(!path.startsWith("/")){
                        path = "/"+path;
                    }
                }


                values.put(path,route);
            }
        }
        log.info("routes:{}",values);
        return values;
    }

    /**
     * 处理服务中心的路由规则
     * @return
     */
    public LinkedHashMap<String,ZuulProperties.ZuulRoute> getServiceRoute() {
        LinkedHashMap<String,ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<>(1<<4);
        //通过服务发现从注册中心获取拥有健康节点的服务列表
        List<String> services = this.getServices();
        /**
         * 将服务信息封装为一个ZuulRoute路由对象
         * 将服务名字设置为ZuulRoute对象的ID和服务ID
         * 设置指定柜子的Regex规则
         */
        if(!ObjectUtils.isEmpty(services)){
            Iterator it13 = services.iterator();
            while (it13.hasNext()){
                String serviceName = (String)it13.next();
                ZuulProperties.ZuulRoute route = new ZuulProperties.ZuulRoute();
                if("gateway".equals(serviceName)){
                    continue;
                }
                route.setId(serviceName);
                /**
                 * 设置路由规则path-serviceId
                 */
                //路由serviceId
                route.setServiceId(serviceName);
                //路由path
                route.setPath("/"+serviceName+"/**");
                routesMap.put(serviceName,route);
            }
        }
        return routesMap;
    }

    /**
     * @Description 获取服务中心的健康服务列表
     * @return String === serviceId
     */
    public List<String> getServices() {
        List<String> serviceNames = this.discoveryClient.getServices();
        if(this.consulClient != null){
            if(ObjectUtils.isEmpty(serviceNames)){
                return new ArrayList<>();
            }
            Iterator<String> it = serviceNames.iterator();
            while (it.hasNext()){
                String serviceName = it.next();
                if(StringUtils.isEmpty(serviceName)){
                    it.remove();
                }
                //获取对象服务名称的节点
                Response response = consulClient.getHealthServices(serviceName,true,null);
                if(response == null){
                    it.remove();
                }
                List<HealthService> healthServices = (List<HealthService>) response.getValue();
                if(ObjectUtils.isEmpty(healthServices)){
                    it.remove();
                }
            }
        }
        return serviceNames;
    }

}
