package com.julius.base.study.test.bat.mock;

import com.julius.base.study.test.bat.mock.service.impl.MockTestOneServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
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


    @Before
    public void setUp(){
        //初始化
        MockitoAnnotations.initMocks(this);
//        doReturn("ab").when(mockTestOneService).getString(any());
    }

    /**
     * 简单的service测试
     */
    @Test
    public void testGetString(){
        List<String> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        String a = "ab";
        //此处使用断言 用来验证方法结果是否符合期望值（bc）实例调用方法
//        Assert.assertThat(mockTestOneService.getString(test),is("ab"));
        //设置接口返回期望值
         when(mockTestOneService.getString(anyString())).thenReturn(a);
         //
        String b = mockTestOneService.getString(anyString());
         Assert.assertEquals(2,b.length());
    }


}
