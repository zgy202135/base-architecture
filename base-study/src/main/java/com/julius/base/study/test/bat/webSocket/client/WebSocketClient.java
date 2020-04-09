package com.julius.base.study.test.bat.webSocket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;

/**
 * @Package: com.julius.base.study.test.bat.webSocket.client
 * @ClassName: WebSocketClient
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/9 9:59
 * @Version: 1.0
 */
@ClientEndpoint
public class WebSocketClient {

    private static final Logger log = LoggerFactory.getLogger(WebSocketClient.class);


    private Session session;


    @OnOpen
    public void onOpen(Session session){
        log.info("client:This is a new session connection !");
        this.session = session;
    }

    @OnClose
    public void onClose(Session session){
        log.info("client:close one session connection !");
    }


    @OnMessage
    public void onMessage(Session session,String message){
        log.info(" client:accept server's message : {},Session ID:{}",message,session.getId());
    }


    @OnError
    public void onError(Throwable throwable){
        throwable.printStackTrace();
    }


    /**
     * @Description 客户端向服务端发送信息
     * @param message
     * @throws Exception
     */
    public void sendTextMessage(String message)throws Exception{
        log.info("The client sends a message to the server :{}",message);
        //阻塞式(同步)发送消息，不推荐
//        session.getBasicRemote().sendText(message);

        //非阻塞式（异步）发送消息
        session.getAsyncRemote().sendText(message);
    }





}
