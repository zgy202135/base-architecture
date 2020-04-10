package com.julius.base.study.test.bat.kafka.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Package: com.julius.base.study.test.bat.kafka.consumer
 * @ClassName: KafkaConsumer
 * @Author: Julius
 * @Description: kafka消费者
 * @Date: 2020/4/10 10:22
 * @Version: 1.0
 */
@Component
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);



    /**
     * Topic
     */

    String topic1 = "topic1";

    String topic2 = "topic2";

    String topic3 = "topic3";

    /**
     * 监听单个主题
     */
    @KafkaListener(topics = {"topic1"})
    public void receive(String message){
        log.info("消费消息：{}",message);
    }

    /**
     * 监听多个主题
     */
    @KafkaListener(topics = {"topic2","topic3"})
    public void receives(String message){
        log.info("消费多个消息：{}",message);
    }

}
