package com.julius.base.study.test.bat.proxy.impl;


import com.julius.base.study.test.bat.proxy.ProxyLearn;

/**
 * @Package: com.julius.base.common.test.bat.proxy.impl
 * @ClassName: BeProxyObject
 * @Author: Julius
 * @Description: 被代理代码实现
 * @Date: 2020/3/25 16:18
 * @Version: 1.0
 */

public class BeProxyObject implements ProxyLearn {
    /**
     * @Description study one language
     */
    @Override
    public void study() {
        System.out.println("study java language");
    }
}
