package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.service.UserService;
import com.example.Exec1_Todo.web.dto.User.UserLoginDto;
import com.example.Exec1_Todo.web.dto.User.UserResponseDto;
import com.example.Exec1_Todo.web.dto.User.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @DeleteMapping("/api/v1/user/delete")
    public ResponseEntity<String> deleteAll(){
        return new ResponseEntity<String>(userService.deleteAll(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        return new ResponseEntity<List<UserResponseDto>>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/find/{email}")
    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email){
        return new ResponseEntity<UserResponseDto>(userService.findByEmail(email), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto requestDto){
        return new ResponseEntity<UserResponseDto>(userService.save(requestDto), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user/login")
    public ResponseEntity<Boolean> login(@RequestBody UserLoginDto requestDto){
        Boolean result = userService.login(requestDto);
        if(result){
            return new ResponseEntity<Boolean>(result, HttpStatus.OK);
        }else{
            return new ResponseEntity<Boolean>(result, HttpStatus.NOT_FOUND);
        }
    }
}
