package com.example.Exec5_NoJpa.web;

import com.example.Exec5_NoJpa.model.dto.UserDto;
import com.example.Exec5_NoJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService a){
        this.userService = a;
    }
    @GetMapping("/getUser")
    public UserDto getUser(){
        return userService.getUser();
    }
}
