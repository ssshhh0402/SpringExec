package com.example.Exec5_NoJpa.service;

import com.example.Exec5_NoJpa.model.dto.user.LoginRequestDto;
import com.example.Exec5_NoJpa.model.dto.user.SignUpRequestDto;
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

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public boolean login(LoginRequestDto dto){
        User user = userRepository.findByEmail(dto.getEmail());
        return user.getPwd().equals(dto.getPwd());
    }

    public void checkEmail(String email){
        User user = userRepository.findByEmail(email);
    }
    public User signUp(SignUpRequestDto dto){
        return userRepository.signUp(dto.getEmail(), dto.getPwd());
    }
    public void deleteAll(){
        userRepository.deleteAll();
    }
    public void deleteOne(long id){
        userRepository.deleteById(id);
    }
    public void update(long id, String pwd){
        userRepository.update(id, pwd);
    }
}
