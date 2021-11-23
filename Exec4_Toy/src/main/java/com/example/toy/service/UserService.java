package com.example.toy.service;

import com.example.toy.domain.user.User;
import com.example.toy.domain.user.UserRepository;
import com.example.toy.web.Dto.User.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserSaveRequestDto requestDto){
        User user = userRepository.save(requestDto.toEntity());
        return new UserResponseDto(user);
    }

    public UserListResponseDto getAll(){
        List<User> users = userRepository.findAll();
        List<UserResponseDto> al = new ArrayList<UserResponseDto>();
        for(User user : users){
            al.add(new UserResponseDto(user));
        }
        return new UserListResponseDto(al);
    }
    public LoginResult login(UserLoginRequestDto requestDto){
        User user = userRepository.findByEmail(requestDto.getEmail());
        if(user.getPassword().equals(requestDto.getPassword())){
            return new LoginResult(true, user);
        }else{
            return new LoginResult(false, new User("",""));
        }
    }
}
