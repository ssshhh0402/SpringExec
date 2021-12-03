package com.example.toy.web.Dto.ChatRoom;

import com.example.toy.domain.chat.ChatRoom;

public class ChatRoomCreateRequestDto {
    private String name;

    public ChatRoomCreateRequestDto(String a){
        this.name = a;
    }
    public String getName(){
        return this.name;
    }
    public ChatRoom toEntity(){
        return ChatRoom.builder()
                .name(this.name)
                .build();
    }

}
