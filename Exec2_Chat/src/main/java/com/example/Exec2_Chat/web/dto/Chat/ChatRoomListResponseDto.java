package com.example.Exec2_Chat.web.dto.Chat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ChatRoomListResponseDto {
    private boolean result;
    private List<ChatRoomResponseDto> data;

    @Builder
    public ChatRoomListResponseDto(boolean result, List<ChatRoomResponseDto> datas){
        this.result = result;
        this.data = datas;
    }
}
