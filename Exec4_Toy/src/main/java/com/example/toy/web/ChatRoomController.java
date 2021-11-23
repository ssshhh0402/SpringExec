package com.example.toy.web;

import com.example.toy.service.ChatRoomService;
import com.example.toy.web.Dto.ChatRoom.ChatRoomCreateRequestDto;
import com.example.toy.web.Dto.ChatRoom.ChatRoomResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/api/v1/rooms")
    public ResponseEntity<List<ChatRoomResponseDto>> getLists(){
        return new ResponseEntity<List<ChatRoomResponseDto>>(chatRoomService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/rooms/create")
    public ResponseEntity<ChatRoomResponseDto> create(@RequestBody ChatRoomCreateRequestDto requestDto){
        return new ResponseEntity<ChatRoomResponseDto>(chatRoomService.create(requestDto),HttpStatus.OK);
    }

}
