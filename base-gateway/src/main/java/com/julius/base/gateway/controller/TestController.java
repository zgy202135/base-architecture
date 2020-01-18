package com.julius.base.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/gateway")
    public String health(){
        return "health";
    }
}
