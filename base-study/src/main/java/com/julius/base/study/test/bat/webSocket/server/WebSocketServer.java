package com.julius.base.study.test.bat.webSocket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.julius.base.study.test.bat.webSocket.server
 * @ClassName: WebSocketServer
 * @Author: Julius
 * @Description: WebSocket 服务端(使用Tomcat的WebSocket实现)
 * <pre>
 *     @Component 注解一定要加
 *     @ServerEndpoint(value="/server/test") 自动注入，value属性是webSocket服务端的url
 * </pre>
 * @Date: 2020/4/9 9:33
 * @Version: 1.0
 */
@Component
@ServerEndpoint(value = "/server/tomcat/test")
public class WebSocketServer {


    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     * 连接会话
     */
    private Session session;


    /**
     * 使用线程安全的map维护session清单列表
     */
    private static ConcurrentHashMap<String,Session> sessionMap = new ConcurrentHashMap<>(1<<4);

    @OnOpen
    public void onOpen(Session session){
        log.info("This is a new session connection !");
        this.session = session;
        sessionMap.put(session.getId(),session);

        log.info("There are 【{}】 connections here",sessionMap.size());
    }

    @OnClose
    public void onClose(Session session){
        log.info("close one session connection !");
        sessionMap.remove(session.getId());
        log.info("There are 【{}】 connections here",sessionMap.size());
    }


    @OnMessage
    public void onMessage(Session session,String message){
        log.info(" accept client's message : {}",message);
        //todo 处理消息 并决定发送给指定客户端，还是群发客户端
        sendAllClient(message);
    }


    @OnError
    public void onError(Throwable throwable){
        throwable.printStackTrace();
    }


    /**
     * @Description 群发
     * @param message
     */
    public void sendAllClient(String message){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("The server send a message to all client");
        for(ConcurrentHashMap.Entry<String,Session> entry : sessionMap.entrySet()){
            entry.getValue().getAsyncRemote().sendText(message);
        }
    }
}
