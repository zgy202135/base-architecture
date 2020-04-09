package com.julius.base.study.test.bat.webSocket.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.julius.base.study.test.bat.webSocket.handler
 * @ClassName: MyTextHandler
 * @Author: Julius
 * @Description: 处理文本信息的自定义处理器
 * @Date: 2020/4/8 16:50
 * @Version: 1.0
 */
public class MyTextHandler extends AbstractWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(MyTextHandler.class);

    /**
     * 使用线程安全的map维护一份连接会话清单
     */
    private static ConcurrentHashMap<String,WebSocketSession> webSocketSessionConcurrentHashMap = new ConcurrentHashMap<>(1<<4);


    /**
     * @Descripotion 重写处理文本信息（接收客户端信息）
     * @param socketSession
     * @param message
     * @throws Exception
     */
    @Override
    public void handleTextMessage(WebSocketSession socketSession, TextMessage message)throws Exception{
        //获取文本信息
        socketSession.sendMessage(new TextMessage("返回信息给客户端："+socketSession.getId()));
    }


    /**
     * 建立连接触发
     * @param session
     * @throws Exception
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        log.info("connection established");
        webSocketSessionConcurrentHashMap.put(session.getId(),session);
        for(ConcurrentHashMap.Entry<String,WebSocketSession> entry : webSocketSessionConcurrentHashMap.entrySet()) {
            TextMessage message = new TextMessage("Connection number is "+webSocketSessionConcurrentHashMap.size());
            entry.getValue().sendMessage(message);
        }
    }

    /**
     * 关闭连接触发
     * @param session
     * @param status
     * @throws Exception
     */
    public void afterConnectionClosed(WebSocketSession session,CloseStatus status) throws Exception{
        log.info("connection closed");
        webSocketSessionConcurrentHashMap.remove(session.getId());
        for(ConcurrentHashMap.Entry<String,WebSocketSession> entry : webSocketSessionConcurrentHashMap.entrySet()) {
            TextMessage message = new TextMessage("Connection number is "+webSocketSessionConcurrentHashMap.size());
            entry.getValue().sendMessage(message);
        }
    }



}
