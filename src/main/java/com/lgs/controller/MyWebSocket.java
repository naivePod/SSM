package com.lgs.controller;

import com.lgs.pojo.Content;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: lgs
 * @Date: 2018-10-30 15:53
 * @Description:WebSocket
 */

@ServerEndpoint(value = "/websocket", configurator = SpringConfigurator.class)
public class MyWebSocket {
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<MyWebSocket> set = new CopyOnWriteArraySet<>();
    private Session session;

    public MyWebSocket() {
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        set.add(this);

        addOnlineCount();
        //todo ip
        System.out.println("有新连接进来的，当前人数："+getOnlineCount()+" IP:");
    }

    @OnClose
    public void onClose() {
        set.remove(this);
        removeOnlineCount();
        System.out.println("有一连接关闭，当前人数"+getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的信息："+message);
        for(MyWebSocket socket : set) {
            try {
                socket.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        Content content = new Content();
        content.setContent(message);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        content.setCreateDate(dateFormat.format(new Date()));
        this.session.getBasicRemote().sendText(message);
    }

    private synchronized int getOnlineCount() {
        return onlineCount;
    }

    private synchronized void addOnlineCount() {
        onlineCount++;
    }

    private synchronized void removeOnlineCount() {
        onlineCount--;
    }
}
