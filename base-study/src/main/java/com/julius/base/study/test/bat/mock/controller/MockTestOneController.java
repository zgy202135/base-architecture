package com.julius.base.study.test.bat.mock.controller;

import com.julius.base.study.test.bat.mock.service.MockTestOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: com.julius.base.study.test.bat.mock.controller
 * @ClassName: MockTestOneController
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/7 14:26
 * @Version: 1.0
 */
@RestController
public class MockTestOneController {

    @Autowired
    private MockTestOneService mockTestOneService;

    @PostMapping(value = "/test/mock")
    public String getString(@RequestBody String list){
        System.out.println("-----------------"+mockTestOneService.getString(list));
        return mockTestOneService.getString(list);
    }
}
