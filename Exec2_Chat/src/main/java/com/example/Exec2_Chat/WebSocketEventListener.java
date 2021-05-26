package com.example.Exec2_Chat;

import com.example.Exec2_Chat.domain.ChatMessage;
import com.example.Exec2_Chat.domain.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Map;


@Component
public class WebSocketEventListener {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnectEventListener(SessionConnectEvent event){
        logger.info(event.toString());
        logger.info("새로운 사람 Connected!!");

    }

    @EventListener
    public void handleWebSockentDisConnectEventListener(SessionDisconnectEvent event){
        logger.info("-------------leave----------");
        logger.info(event.toString());
        logger.info("Dis Connected");
        logger.info("----------------------------");
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String userName = (String)headerAccessor.getSessionAttributes().get("username");
        if(userName != null){
            logger.info("UserName : " + userName);
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(MessageType.LEAVE);
            chatMessage.setSender(userName);
            messageSendingOperations.convertAndSend("/topic/public", chatMessage);
        }
    }
}
