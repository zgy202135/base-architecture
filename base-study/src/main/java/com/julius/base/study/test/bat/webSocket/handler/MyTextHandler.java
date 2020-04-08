package com.julius.base.study.test.bat.webSocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @Package: com.julius.base.study.test.bat.webSocket.handler
 * @ClassName: MyTextHandler
 * @Author: Julius
 * @Description: 处理文本信息的自定义处理器
 * @Date: 2020/4/8 16:50
 * @Version: 1.0
 */
@Component
public class MyTextHandler extends TextWebSocketHandler {


    /**
     * @Descripotion 重写处理文本信息
     * @param socketSession
     * @param message
     * @throws Exception
     */
    @Override
    public void handleTextMessage(WebSocketSession socketSession, TextMessage message)throws Exception{

        //获取文本信息
        String text = message.getPayload();

        socketSession.sendMessage(new TextMessage("返回信息："+message));
    }
}
