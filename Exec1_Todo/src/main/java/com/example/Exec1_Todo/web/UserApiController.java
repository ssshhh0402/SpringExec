package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.service.UserService;
import com.example.Exec1_Todo.web.dto.User.*;
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
    @DeleteMapping("/api/v1/user/delete/{userId}")
    public ResponseEntity<String> deleteOne( @PathVariable long userId){
        return new ResponseEntity<String>(userService.deleteOne(userId), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        return new ResponseEntity<List<UserResponseDto>>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/find/{email}")
    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email){
        return new ResponseEntity<UserResponseDto>(userService.findByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/find/send/{email}")
    public ResponseEntity<String> findEmail(@PathVariable String email){
        return new ResponseEntity<String>(userService.findEmail(email), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto requestDto){
        return new ResponseEntity<UserResponseDto>(userService.save(requestDto), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginDto requestDto){
        return new ResponseEntity<UserLoginResponseDto>(userService.login(requestDto), HttpStatus.OK);
    }
    @PutMapping("api/v1/user/change")
    public ResponseEntity<UserLoginResponseDto> change(@RequestBody UserInfoChangeDto requestDto){
        return new ResponseEntity<UserLoginResponseDto>(userService.changePassword(requestDto), HttpStatus.OK);

    }
}
