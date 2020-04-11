package com.julius.base.study.test.bat.kafka.config;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.julius.base.study.test.bat.kafka.config
 * @ClassName: KafkaConfiguration
 * @Author: Julius
 * @Description: Kafka 配置类
 * <pre>
 *     SpringBoot中含有kafka的自动配置，只需在application配置文件中配置即可。
 *     当需要非常复杂的配置时，才会使用该配置类进行自定义配置
 * </pre>
 * @Date: 2020/4/10 10:06
 * @Version: 1.0
 */
@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Value(value = "${spring.kafka.producer.batch-size}")
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

        //设置序列化方式
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return props;
    }


    /**
     * 生产者工厂
     * @return
     */
    @Bean
    public ProducerFactory<String,Object> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    /**
     * 生产者模板
     * @return
     */
    @Bean
    public KafkaTemplate<String,Object> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }


    /**
     * 监听容器工厂
     * @return
     */
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(listenerConcurrency);
        factory.setMissingTopicsFatal(listenerMissingTopic);
        factory.getContainerProperties().setPollTimeout(1500);
        return factory;
    }

    /**
     * 消费者工厂
     * @return
     */
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }


    /**
     * 消费者配置
     * @return
     */
    @Bean
    public Map<String,Object> consumerConfig(){
        Map<String,Object> props = new HashMap<>(1<<4);

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,consumerGroup);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_DOC,consumerOffset);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,consumerCommit);

        //注意此处应该配置反序列化
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        return props;
    }


}
