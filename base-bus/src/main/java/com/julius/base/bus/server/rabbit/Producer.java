package com.julius.base.bus.server.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Package: com.julius.base.bus.server.rabbit
 * @ClassName: Producer
 * @Author: Julius
 * @Description: RabbitMQ 生产者
 * @Date: 2020/4/24 13:21
 * @Version: 1.0
 */
@Component
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);



    @Autowired
    private AmqpTemplate amqpTemplate;

    public void doSend(){
        String message = "hello "+new Date();

        log.info("RabbitMQ send message:{}",message);
        String queueName = "julius";

        this.amqpTemplate.convertAndSend(queueName,message);

    }
}
