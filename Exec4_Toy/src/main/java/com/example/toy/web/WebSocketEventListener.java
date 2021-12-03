package com.example.toy.web;

import com.example.toy.domain.chat.ChatMessage;
import com.example.toy.domain.chat.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

    @Autowired
    private SimpMessageSendingOperations messagingTemplates;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event){
        System.out.println("NEW WEB SOCKET CONNECTED!@#!@#!#!$!%^!^!#$!@#$!@%!^");
    }

    @EventListener
    public void handleWebSocketDisconnetListener(SessionDisconnectEvent event){
        StompHeaderAccessor accesor = StompHeaderAccessor.wrap(event.getMessage());
        String userName = (String)accesor.getSessionAttributes().get("username");
        if(userName != null){
            ChatMessage message = new ChatMessage();
            message.setSender(userName);
            message.setType(MessageType.LEAVE);
            messagingTemplates.convertAndSend("/topic/public", message);
        }
    }
}
