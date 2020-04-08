package com.julius.base.study.test.bat.mock;

import com.julius.base.study.test.bat.mock.service.OtherService;
import com.julius.base.study.test.bat.mock.service.impl.MockTestOneServiceImpl;
import com.julius.base.study.test.bat.mock.service.impl.OtherServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * @Package: com.julius.base.study.test.bat.mock
 * @ClassName: MockTestOneServiceTest
 * @Author: Julius
 * @Description: mock service 测试类
 * Usually when you do integration testing, you should use real dependencies. So remove mocking
 * Usually when you are unit testing, you shouldn't initialize Spring context. So remove Autowiring
 *
 * 不错的文档：
 * https://www.jianshu.com/p/bb705a56f620
 *
 *
 * @Date: 2020/4/7 14:04
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
//@SpringBootTest 加该注解时会启动SpringBoot
public class MockTestOneServiceTest {
    /**
     * 模拟被测试实例对象，被测试对象的实例对象只能使用该注解
     */
    @InjectMocks
    MockTestOneServiceImpl mockTestOneService;

    /**
     * @Mock 模拟对象 不会使用该对象的真实逻辑
     * @Spy 模拟对象 但是使用的方法都是真是逻辑
     */
    @Mock
    OtherServiceImpl otherService;


    public void setUp(){
        //初始化 将@Spy和@Mock注解的对象设置service中
//        MockitoAnnotations.initMocks(this);
    }

    /**
     * 简单的service测试
     */
    @Test
    public void testGetString(){
        String a = "ab";
        //设置模拟对象的接口期望值(当不走真实数据逻辑时)
        when(otherService.getOtherString()).thenReturn("there");

        //先设置期望值，然后@Mock返回null,@Spy返回真实逻辑值
//        doReturn("there").when(otherService);

        String b = mockTestOneService.getString(a);
        //使用断言验证接口返回的值是否正确
        Assert.assertEquals(7,b.length());
    }


}
