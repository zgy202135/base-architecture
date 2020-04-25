package com.julius.base.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.julius.base.bus.controller
 * @ClassName: TestController
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/24 14:08
 * @Version: 1.0
 */
@RefreshScope
@RestController
public class TestController {


    @Autowired
    private Environment environment;


    @GetMapping("/form")
    public String form(){
        return environment.getProperty("form");
    }
}
