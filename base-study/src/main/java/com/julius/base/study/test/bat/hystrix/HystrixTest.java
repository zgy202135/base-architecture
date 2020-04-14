package com.julius.base.study.test.bat.hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

/**
 * @Package: com.julius.base.study.test.bat.hystrix
 * @ClassName: HystrixTest
 * @Author: Julius
 * @Description: 服务熔断Hystrix实例理解
 * @Date: 2020/4/13 9:31
 * @Version: 1.0
 */
public class HystrixTest<T> extends HystrixCommand<T> {


    /**
     * rest请求模板
     */
    private RestTemplate restTemplate;

    private long id;

    protected HystrixTest(Setter setter) {
        super(setter);
    }

    protected HystrixTest(Setter setter,RestTemplate restTemplate,long id){
        //设置命令分组，命令名称，线程分组
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("group1"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("command1"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("pool1")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected T run() throws Exception {
        //构建get请求
        return restTemplate.getForObject("url", (Class<T>) Object.class);
    }

    @Override
    protected T getFallback(){
        return (T) Object.class;
    }


    /**
     * 开启缓存
     * @return
     */
    @Override
    protected  String getCacheKey(){
        return "open";
    }


    /**
     * 刷新缓存
     * @param cacheKey
     */
    public static void flushCache(String cacheKey){
        //命令名称，缓存key
        HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey("command1"), HystrixConcurrencyStrategyDefault.getInstance()).clear(cacheKey);
    }




}
