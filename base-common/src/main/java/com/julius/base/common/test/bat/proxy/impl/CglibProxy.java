package com.julius.base.common.test.bat.proxy.impl;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Package: com.julius.base.common.test.bat.proxy.impl
 * @ClassName: CglibProxy
 * @Author: Julius
 * @Description: Cglib 动态代理
 * @Date: 2020/3/26 13:42
 * @Version: 1.0
 */
public class CglibProxy {
    private Object target;

    public Object getInstance(final Object target){
        this.target = target;
        //为接口或者类生成java代理
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib proxy before");
                Object result = method.invoke(target,objects);
                System.out.println("cglib proxy after");
                return result;
            }
        });
        return enhancer.create();
    }

}
