package com.julius.base.study.test.bat.kafka.controller;

import com.julius.base.study.test.bat.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.julius.base.study.test.bat.kafka.controller
 * @ClassName: KafkaController
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/10 10:33
 * @Version: 1.0
 */
@RestController
public class KafkaController {


    @Autowired
    private KafkaProducer kafkaProducer;


    @PostMapping(value = "/kafka/send")
    public void send(){
        kafkaProducer.send();
    }
}
