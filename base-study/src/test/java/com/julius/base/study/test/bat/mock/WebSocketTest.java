package com.julius.base.study.test.bat.mock;

import com.julius.base.study.BaseStudyApplication;
import com.julius.base.study.test.bat.webSocket.client.WebSocketClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

/**
 * @Package: com.julius.base.study.test.bat.mock
 * @ClassName: WebSocketTest
 * @Author: Julius
 * @Description: ${description}
 * @Date: 2020/4/9 10:18
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseStudyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebSocketTest {

    private String url1 = "ws://localhost:8080/server/tomcat/test";
    private String url2 = "ws://localhost:8080/server/spring/test";

    @Test
    public void testSendMessageToServer()throws Exception{
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        int count = 1;
        while (true){
            WebSocketClient client = new WebSocketClient();
            container.connectToServer(client,new URI(url2));
            client.sendTextMessage("this is test class"+count++);
            Thread.sleep(5000);
        }
    }
}
