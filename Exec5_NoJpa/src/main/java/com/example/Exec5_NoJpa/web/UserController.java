package com.example.Exec5_NoJpa.web;

import com.example.Exec5_NoJpa.model.dto.LoginRequestDto;
import com.example.Exec5_NoJpa.model.dto.UserDto;
import com.example.Exec5_NoJpa.model.user.User;
import com.example.Exec5_NoJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService a){
        this.userService = a;
    }


    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }
    @GetMapping("/getUser")
    public User getUserByEmail(@RequestParam("email") String email){
        User user = userService.getUserByEmail(email);
        return user;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        try{
            userService.login(dto);
            if(!userService.login(dto)){
                return new ResponseEntity<String>("아이디|비번 불일치", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

}
