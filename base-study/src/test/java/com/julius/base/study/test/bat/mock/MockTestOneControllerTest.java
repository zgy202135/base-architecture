package com.julius.base.study.test.bat.mock;

import com.julius.base.study.test.bat.mock.controller.MockTestOneController;
import com.julius.base.study.test.bat.mock.service.impl.MockTestOneServiceImpl;
import com.julius.base.study.test.bat.mock.service.impl.OtherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Package: com.julius.base.study.test.bat.mock
 * @ClassName: MockTestOneControllerTest
 * @Author: Julius
 * @Description: controller 单元测试
 * <pre>
 *     单元测试可以分为：Service 单元测试和Controller 单元测试
 *     这两种情况一般都是对被测试对象使用@InjectMocks注解（会将@Mock和@Spy注解的模拟对象注入到@InjectMocks的模拟对象中）
 *     被测试对像的其他注入实例使用@Mock生成模拟对象，并对接口模拟期望值
 *     而@Spy直接一般是要执行该模拟对象的真实逻辑。
 * </pre>
 * @Date: 2020/4/7 14:28
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
public class MockTestOneControllerTest {

    //模拟mvc环境
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
        //初始化MockMvc ，构建mvc环境
        mockMvc = MockMvcBuilders.standaloneSetup(mockTestOneController).build();

    }


    @Test
    public void testGetStringController()throws Exception{
        String a = "zhougaoyang1";
        String test = "zhougaoyang2";

        //设置模拟对象的期望值（打桩数据）
        when(mockTestOneService.getString(any(String.class))).thenReturn(a);

        //构建请求
        RequestBuilder request = MockMvcRequestBuilders.post("/test/mock")
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .accept(MediaType.APPLICATION_JSON)
                                                        .content(test);

        //结果断言
       MvcResult result =  mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
       System.out.println("------------result:"+result.getResponse().getContentAsString());
    }


}
