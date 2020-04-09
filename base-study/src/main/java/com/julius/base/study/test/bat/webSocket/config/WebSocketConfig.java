package com.julius.base.study.test.bat.webSocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Package: com.julius.base.study.test.bat.webSocket.config
 * @ClassName: WebSocketConfig
 * @Author: Julius
 * @Description: WebSocket 服务端配置类
 * @Date: 2020/4/9 9:29
 * @Version: 1.0
 */
@Configuration
public class WebSocketConfig {


    /**
     * @Description 自动注册使用了@ServerEndpoint注解的WebSocket endpoint
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
