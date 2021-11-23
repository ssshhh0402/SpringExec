package com.example.toy.service;

import com.example.toy.domain.chat.ChatRoom;
import com.example.toy.domain.chat.ChatRoomRepository;
import com.example.toy.web.Dto.ChatRoom.ChatRoomCreateRequestDto;
import com.example.toy.web.Dto.ChatRoom.ChatRoomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    public List<ChatRoomResponseDto> findAll(){
        List<ChatRoom> rooms = chatRoomRepository.findAll();
        List<ChatRoomResponseDto> result = new ArrayList<ChatRoomResponseDto>();
        for(ChatRoom room : rooms){
            result.add(new ChatRoomResponseDto(room));
        }
        return result;
    }

    @Transactional
    public ChatRoomResponseDto create(ChatRoomCreateRequestDto requestDto){
        ChatRoom chatRoom = chatRoomRepository.save(requestDto.toEntity());
        return new ChatRoomResponseDto(chatRoom);
    }
}
