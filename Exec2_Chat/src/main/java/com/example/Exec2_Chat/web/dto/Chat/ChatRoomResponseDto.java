package com.example.Exec2_Chat.web.dto.Chat;

import com.example.Exec2_Chat.domain.chat.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomResponseDto {
    private String name, url;

    @Builder
    public ChatRoomResponseDto( ChatRoom chatRoom){
        this.name = chatRoom.getName();
        this.url = chatRoom.getUrl();
    }
}
