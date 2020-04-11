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

    static final String topic1 = "topic1";

    static final String topic2 = "topic2";

    static final String topic3 = "topic3";

    /**
     * 监听单个主题
     */
    @KafkaListener(topics = {KafkaConsumer.topic1})
    public void receive(String message){
        log.info("消费消息：{}",message);
    }

    /**
     * 监听多个主题
     */
    @KafkaListener(topics = {KafkaConsumer.topic2,KafkaConsumer.topic3})
    public void receives(String message){
        log.info("消费多个消息：{}",message);
    }

    /**
     * 监听配置文件中的多个主题
     * @param message
     */
    @KafkaListener(topics = {"${topic.name.topic1}","${topic.name.topic2}","${topic.name.topic3}"})
    public void receiveProperties(String message){
        log.info("监听配置文件中的主题 :{}",message);
    }

    @KafkaListener(topics = "#{'${topic.names}'.split(',')}")
    public void receiveNames(String message){
        log.info("-------------：{}",message);
    }

}
