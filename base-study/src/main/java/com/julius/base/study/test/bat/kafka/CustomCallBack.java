package com.julius.base.study.test.bat.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @Package: com.julius.base.study.test.bat.kafka
 * @ClassName: Custom
 * @Author: Julius
 * @Description: 自定义回调
 * @Date: 2020/4/11 10:29
 * @Version: 1.0
 */
@Component
public class CustomCallBack<K,V> {
    private static final Logger log = LoggerFactory.getLogger(CustomCallBack.class);


    /**
     * @Description 发送消息回调
     * @param topic
     * @param future
     */
    public void sendCallBack(String topic,ListenableFuture<SendResult<K,V>> future){
        future.addCallback(new ListenableFutureCallback<SendResult<K, V>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info(topic +"发送消息失败,error :{}",ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<K, V> result) {
                log.info(topic +" 发送消息成功: {}",result.toString());
            }
        });
    }
}
