package com.example.Exec5_NoJpa.service;

import com.example.Exec5_NoJpa.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto getUser(){
        UserDto dto = new UserDto(1, "A", "B");
        return dto;
    }
}
