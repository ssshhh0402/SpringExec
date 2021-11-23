package com.example.toy.web.Dto.ChatRoom;

import com.example.toy.domain.chat.ChatRoom;

public class ChatRoomResponseDto {
    long id;
    String name;

    public ChatRoomResponseDto(ChatRoom room){
        this.id = room.getId();
        this.name = room.getName();
    }
}
