package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.service.UserService;
import com.example.Exec1_Todo.web.dto.User.UserLoginDto;
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


    @GetMapping("/api/v1/user/")
    public ResponseEntity<List<User>> findAllUser(){
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/find/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email){
        return new ResponseEntity<User>(userService.findByEmail(email), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user")
    public ResponseEntity<User> save(@RequestBody UserSaveRequestDto requestDto){
        return new ResponseEntity<User>(userService.save(requestDto), HttpStatus.OK);
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
