package com.example.Exec5_NoJpa.service;

import com.example.Exec5_NoJpa.model.dto.UserDto;
import com.example.Exec5_NoJpa.model.user.User;
import com.example.Exec5_NoJpa.model.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserDto getUser(){
        UserDto dto = new UserDto(1, "A", "B");
        return dto;
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public List<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
