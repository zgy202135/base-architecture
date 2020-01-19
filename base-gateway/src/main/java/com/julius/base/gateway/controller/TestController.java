package com.julius.base.gateway.controller;

import com.julius.base.gateway.route.CustomRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package: com.julius.base.gateway.controller
 * @ClassName: TestController
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/1/18 11:06
 * @Version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private CustomRouteLocator customRouteLocator;

    @GetMapping("/gateway")
    public String health(){
        return "health";
    }

    @GetMapping("/gateway/service")
    public List<String> getServices(){
        return customRouteLocator.getServices();
    }
}
