package com.julius.base.study.test.bat.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Package: com.julius.base.study.test.bat.kafka.producer
 * @ClassName: KafkaProducer
 * @Author: Julius
 * @Description: Kafka生产者
 * @Date: 2020/4/10 10:11
 * @Version: 1.0
 */
@Component
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    /**
     * 自动注入kafka模板
     */
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    String topic1 = "topic1";
    String topic2 = "topic2";
    String topic3 = "topic3";


    public void send(){
        log.info("发送消息：{}","测试生产者");
        kafkaTemplate.send(topic1,"测试生产者");
        kafkaTemplate.send(topic2,"测试生产者2");
        kafkaTemplate.send(topic3,"测试生产者3");
    }


}
