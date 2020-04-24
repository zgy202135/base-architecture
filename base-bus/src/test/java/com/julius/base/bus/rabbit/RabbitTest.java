package com.julius.base.bus.rabbit;

import com.julius.base.bus.server.rabbit.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Package: com.julius.base.bus.rabbit
 * @ClassName: RabbitTest
 * @Author: Julius
 * @Description: Rabbit 测试类
 * @Date: 2020/4/24 13:31
 * @Version: 1.0
 */
@SpringBootTest
public class RabbitTest {

    @Autowired
    private Producer producer;



    @Test
    public void TestSend(){
        producer.doSend();
    }
}
