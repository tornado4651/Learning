package com.tornado4651.websocket;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Slf4j
@Component
@ServerEndpoint("/websocket")
public class SocketEndPoint {
    /**
     * socket链接打开时执行
     */
    @OnOpen
    public void onOpen(Session session) {
        log.info("有连接【{}】加入！", session.getId());
    }


    @OnMessage
    public void onMessage(String text, Session session) {
        log.info("收到来自【{}】的消息：{}", session.getId(), text);
    }


    /**
     * socket链接关闭时执行
     */
    @OnClose
    public void onClose(Session session) {
        log.info("连接【{}】关闭！", session.getId());
    }


    /**
     * socket链接关闭时执行
     */
    @OnError
    public void onError(Throwable throwable) {
        log.error("连接发生错误！错误原因：{}", throwable.getMessage());
    }


}
