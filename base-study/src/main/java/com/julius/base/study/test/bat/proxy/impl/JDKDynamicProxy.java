package com.julius.base.study.test.bat.proxy.impl;

/**
 * @Package: com.julius.base.common.test.bat.proxy.impl
 * @ClassName: JDKDynamicProxy
 * @Author: Julius
 * @Description: JDK动态代理
 * @Date: 2020/3/25 16:30
 * @Version: 1.0
 */
public class JDKDynamicProxy {
    private Object target;
    public JDKDynamicProxy(Object target){
        this.target = target;
    }
    /**
     * 获取被代理接口实例对象
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) MyProxyFactory.getProxyObject(target);
    }
}
