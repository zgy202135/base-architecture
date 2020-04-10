package com.julius.base.study.test.bat.kafka.config;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.julius.base.study.test.bat.kafka.config
 * @ClassName: KafkaConfiguration
 * @Author: Julius
 * @Description: Kafka 配置类
 * @Date: 2020/4/10 10:06
 * @Version: 1.0
 */
//@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Value(value = "{spring.kafka.producer.batch-size}")
    private Integer producerBatchSize;

    @Value(value = "${spring.kafka.producer.buffer-memory}")
    private Integer producerBufferMemory;

    @Value(value = "${spring.kafka.producer.retries}")
    private Integer producerRetries;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String consumerGroup;

    @Value(value = "${spring.kafka.consumer.auto-offset-reset}")
    private String consumerOffset;

    @Value(value = "${spring.kafka.consumer.enable-auto-commit}")
    private Boolean consumerCommit;

    @Value(value = "${spring.kafka.listener.concurrency}")
    private Integer listenerConcurrency;

    @Value(value = "${spring.kafka.listener.missing-topics-fatal}")
    private Boolean listenerMissingTopic;


    /**
     * 生产者配置信息
     * @return
     */
    @Bean
    public Map<String,Object> producerConfig(){
        Map<String,Object> props = new HashMap<>(1<<4);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServer);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,producerBatchSize);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,producerBufferMemory);
        props.put(ProducerConfig.RETRIES_CONFIG,producerRetries);
        return props;
    }


    /**
     * 生产者工厂
     * @return
     */
    @Bean
    public ProducerFactory<String,String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    /**
     * 生产者模板
     * @return
     */
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }








}
