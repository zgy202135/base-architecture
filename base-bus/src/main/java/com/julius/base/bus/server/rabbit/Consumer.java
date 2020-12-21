package com.julius.base.bus.server.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @Package: com.julius.base.bus.server.rabbit
 * @ClassName: Consumer
 * @Author: Julius
 * @Description: RabbitMQ 消费者
 * @Date: 2020/4/24 13:25
 * @Version: 1.0
 */
@Component
public class Consumer implements Sink {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    @RabbitListener(queues = {"julius"})
    public void receive(String message){
        log.info("Rabbit accept message:{}",message);
    }

    /**
     * @return input channel.
     */
    @Override
    public SubscribableChannel input() {
        return null;
    }
}
