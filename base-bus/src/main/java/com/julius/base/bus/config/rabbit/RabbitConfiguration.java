package com.julius.base.bus.config.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @Package: com.julius.base.bus.config.rabbit
 * @ClassName: RabbitConfiguration
 * @Author: Julius
 * @Description: Rabbit 配置类
 * @Date: 2020/4/24 13:28
 * @Version: 1.0
 */
@Configuration
public class RabbitConfiguration {

    /**
     * todo 需优化
     */
    @Bean
    public Queue helloQueue(){
        return new Queue("julius");
    }
}
