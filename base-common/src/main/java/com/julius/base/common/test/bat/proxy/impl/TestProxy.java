package com.julius.base.common.test.bat.proxy.impl;

import com.julius.base.common.test.bat.proxy.ProxyLearn;

/**
 * @Package: com.julius.base.common.test.bat.proxy.impl
 * @ClassName: TestProxy
 * @Author: Julius
 * @Description: 测试代理
 * @Date: 2020/3/25 16:25
 * @Version: 1.0
 */
public class TestProxy {


    public static void main(String[] args) {
        //测试静态代理
        /**
         *  1:代理类和被代理类必须实现统一接口
         *  2：代理类构造器要初始化被代理类对象
         *  3：接口一旦发生变化，代理类和被代理类要同时维护
         */
        BeProxyObject beProxyObject = new BeProxyObject();
        StaticProxyObject staticProxyObject = new StaticProxyObject(beProxyObject);
        staticProxyObject.study();

        //测试JDk动态代理
        /**
         * 1:JDK动态代理中的被代理类必须实现接口，因为默认的代理对象是继承了Proxy的，java是单继承，所有只能通过接口实现伪多继承
         * 2:代理类不需要和被代理类实现同一接口
         * 3:底层利用了Java反射机制
         */
        ProxyLearn proxy2 = new JDKDynamicProxy(new BeProxyObject()).getProxy();
        proxy2.study();


        /**
         *  1:Cglib动态代理通过字节码技术为被代理类生成子类
         *  2:并在子类中使用方法拦截的技术拦截对父类方法的全部调用
         *  3:Cglib代理的类可以不实现任何接口
         *  4:关键类为Enhancer 实现类子类的创建，函数回调，回到拦截；MethodInterceptor 接口，创建回调方法
         */
        //测试Cglib动态代理
        CglibBeProxy cglibBeProxy = new CglibBeProxy();
        CglibProxy cglibProxy = new CglibProxy();
        CglibBeProxy cglibBeProxy1 = (CglibBeProxy) cglibProxy.getInstance(cglibBeProxy);
        cglibBeProxy1.cglib();

    }
}
