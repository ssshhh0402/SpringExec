package com.example.Exec2_Chat.web;

import com.example.Exec2_Chat.service.UserService;
import com.example.Exec2_Chat.web.dto.User.UserLoginRequestDto;
import com.example.Exec2_Chat.web.dto.User.UserResponseDto;
import com.example.Exec2_Chat.web.dto.User.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/v1/user")
    public ResponseEntity<List<UserResponseDto>> getAll(){
        return new ResponseEntity<List<UserResponseDto>>(userService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto requestDto){
        return new ResponseEntity<UserResponseDto>(userService.save(requestDto), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/user/deleteAll")
    public ResponseEntity<String> deleteAll(){
        return new ResponseEntity<String>(userService.deleteAll(), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserLoginRequestDto requestDto){
        System.out.println("로그인 들어왔따!!!!!!!!!!");
        return new ResponseEntity<UserResponseDto>(userService.login(requestDto), HttpStatus.OK);
    }

}
