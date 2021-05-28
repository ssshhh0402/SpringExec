package com.example.Exec2_Chat.web;


import com.example.Exec2_Chat.domain.chat.ChatMessage;
import com.example.Exec2_Chat.service.ChatService;
import com.example.Exec2_Chat.web.dto.Chat.ChatRoomListResponseDto;
import com.example.Exec2_Chat.web.dto.Chat.ChatRoomResponseDto;
import com.example.Exec2_Chat.web.dto.Chat.ChatRoomSaveRequestDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChatApiController {
    private final ChatService chatService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage message){
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage message, SimpMessageHeaderAccessor accessor){
        accessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

    @GetMapping("/api/v1/chat/")
    public ResponseEntity<ChatRoomListResponseDto> findAll(){
        return new ResponseEntity<ChatRoomListResponseDto>(chatService.findALl(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/chat/")
    public ResponseEntity<ChatRoomResponseDto> save(@RequestBody ChatRoomSaveRequestDto requestDto){
        return new ResponseEntity<ChatRoomResponseDto>(chatService.save(requestDto), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/chat/")
    public ResponseEntity<Boolean> deleteAll(){
        return new ResponseEntity<Boolean>(chatService.deleteAll(), HttpStatus.OK);
    }
}
