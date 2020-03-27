package com.julius.base.study.test.bat.proxy.impl;

import com.julius.base.study.test.bat.proxy.ProxyLearn;

/**
 * @Package: com.julius.base.common.test.bat.proxy.impl
 * @ClassName: StaticProxyObject
 * @Author: Julius
 * @Description: 静态代理
 * <tr>1:静态代理对象 必须和被代理对象实现同一个接口<tr/>
 * <tr>2:必须有被代理对象的引用</tr>
 * @Date: 2020/3/25 16:20
 * @Version: 1.0
 */
public class StaticProxyObject implements ProxyLearn {

    private BeProxyObject beProxyObject;

    public StaticProxyObject(){
        super();
    }

    public StaticProxyObject(BeProxyObject beProxyObject){
        super();
        this.beProxyObject = beProxyObject;
    }




    /**
     * @Description study one language
     */
    @Override
    public void study() {
        System.out.println("first study english");
        beProxyObject.study();
        System.out.println("end study source code ");

    }
}
