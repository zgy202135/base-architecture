package com.julius.base.study.test.bat.mock;

import com.julius.base.study.test.bat.mock.controller.MockTestOneController;
import com.julius.base.study.test.bat.mock.service.MockTestOneService;
import com.julius.base.study.test.bat.mock.service.impl.MockTestOneServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Package: com.julius.base.study.test.bat.mock
 * @ClassName: MockTestOneControllerTest
 * @Author: Julius
 * @Description: controller 单元测试
 * @Date: 2020/4/7 14:28
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
public class MockTestOneControllerTest {


    MockMvc mockMvc;

    @Mock
    MockTestOneServiceImpl mockTestOneService;

    @InjectMocks
    MockTestOneController mockTestOneController;


    /**
     * 当需要在被测试实例中注入其他实例时，需要使用方法和注解
     */
    @Before
    public void setUp()throws Exception{
        //会将标记了 @Mock 或 @Spy 的属性注入到 service 中,这时控制层中的service对象有mock对象替换
        MockitoAnnotations.initMocks(this);
        //初始化MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(mockTestOneController).build();

    }


    @Test
    public void testGetStringController(){
        List<String> test = new ArrayList<>();
        test.add("d");
        test.add("j");
        test.add("j");
        //模拟请求
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/test/mock")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(String.valueOf(test))
            ).andDo(print())
            .andExpect(status().isOk())
            .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
