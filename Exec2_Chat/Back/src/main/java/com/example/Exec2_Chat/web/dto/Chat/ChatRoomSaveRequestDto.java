package com.example.Exec2_Chat.web.dto.Chat;

import com.example.Exec2_Chat.domain.chat.ChatRoom;
import com.example.Exec2_Chat.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChatRoomSaveRequestDto {
    private long userId;
    private String name;

    @Builder
    public ChatRoomSaveRequestDto(long a, String b){
        this.userId = a;
        this.name = b;
    }

    public ChatRoom toEntity(User author){
        return ChatRoom.builder()
                .name(this.name)
                .creator(author)
                .build();
    }
}
