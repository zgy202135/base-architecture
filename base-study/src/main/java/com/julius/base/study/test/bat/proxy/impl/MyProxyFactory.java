package com.julius.base.study.test.bat.proxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Package: com.julius.base.common.test.bat.proxy.impl
 * @ClassName: MyProxyFactory
 * @Author: Julius
 * @Description: 自定义代理类工厂
 * @Date: 2020/3/25 16:32
 * @Version: 1.0
 */
public class MyProxyFactory {

    public static <T> T getProxyObject(T t){
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("study before to do something");
                Object result = method.invoke(t,args);
                return result;
            }
        });
    }
}
