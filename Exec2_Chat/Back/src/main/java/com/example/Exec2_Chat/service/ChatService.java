package com.example.Exec2_Chat.service;

import com.example.Exec2_Chat.domain.chat.ChatRoom;
import com.example.Exec2_Chat.domain.chat.ChatRoomRepository;
import com.example.Exec2_Chat.domain.user.User;
import com.example.Exec2_Chat.domain.user.UserRepository;
import com.example.Exec2_Chat.web.dto.Chat.ChatRoomListResponseDto;
import com.example.Exec2_Chat.web.dto.Chat.ChatRoomResponseDto;
import com.example.Exec2_Chat.web.dto.Chat.ChatRoomSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    public ChatRoomListResponseDto findALl(){
        List<ChatRoom> chatRooms = chatRoomRepository.findAll();
        List<ChatRoomResponseDto> rooms = new ArrayList<ChatRoomResponseDto>();
        for(ChatRoom chatRoom : chatRooms){
            rooms.add(new ChatRoomResponseDto(chatRoom));
        }
        return new ChatRoomListResponseDto(true, rooms);
    }

    public ChatRoomResponseDto findOne(long id){
        ChatRoom result = chatRoomRepository.findById(id);
        return new ChatRoomResponseDto(result);
    }
    public ChatRoomResponseDto save(ChatRoomSaveRequestDto requestDto){
        User creator = userRepository.getById(requestDto.getUserId());
        ChatRoom newOne = chatRoomRepository.save(requestDto.toEntity(creator));
        return new ChatRoomResponseDto(newOne);
    }
    public boolean deleteAll(){
        try{
            chatRoomRepository.deleteAll();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
