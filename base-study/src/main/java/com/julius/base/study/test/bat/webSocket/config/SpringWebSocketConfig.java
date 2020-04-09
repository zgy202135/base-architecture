package com.julius.base.study.test.bat.webSocket.config;

import com.julius.base.study.test.bat.webSocket.handler.MyTextHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Package: com.julius.base.study.test.bat.webSocket.config
 * @ClassName: SpringWebSocketConfig
 * @Author: Julius
 * @Description: 使用Spring 实现WebSocket 服务端配置
 * @Date: 2020/4/9 11:13
 * @Version: 1.0
 */
@Configuration
@EnableWebSocket
public class SpringWebSocketConfig implements WebSocketConfigurer {

    /**
     * Register {@link com.julius.base.study.test.bat.webSocket.handler.MyTextHandler MyTextHandler} including SockJS fallback options if desired.
     *
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //此处可以注册webSocket服务端，设置拦截器等
        registry.addHandler(myTextHandler(),"server/spring/test").setAllowedOrigins("*");
    }


    @Bean
    public WebSocketHandler myTextHandler(){
        return new MyTextHandler();
    }
}
