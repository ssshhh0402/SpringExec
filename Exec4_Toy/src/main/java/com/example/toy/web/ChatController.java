package com.example.toy.web;

import com.example.toy.domain.chat.ChatMessage;
import com.example.toy.domain.chat.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage message){
//        return message;
//    }

//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage message, SimpMessageHeaderAccessor accesor){
//        accesor.getSessionAttributes().put("username", message.getSender());
//        return message;
//    }
    // roomId가 아니라 userId로 구독을 해봅시다
    @MessageMapping("/chat/message")
    public void message(ChatMessage message){
        if(message.getType().equals(MessageType.JOIN)){
            message.setMessage(message.getSender()+"님이 입장하셨습니다");
        }else if(message.getType().equals(MessageType.LEAVE)){
            message.setMessage(message.getSender()+"님이 퇴장하셨습니다");
        }else if(message.getType().equals(MessageType.CREATE)){

        }
        messagingTemplate.convertAndSend("/sub/chat/room/"+message.getRoomId(), message);
    }

}
