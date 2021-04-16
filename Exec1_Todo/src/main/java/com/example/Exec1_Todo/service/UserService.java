package com.example.Exec1_Todo.service;


import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.User.UserLoginDto;
import com.example.Exec1_Todo.web.dto.User.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional
    public User save(UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity());
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Boolean login(UserLoginDto requestDto){
        return requestDto.getPassword().equals(userRepository.findByEmail(requestDto.getEmail()).getPassword());
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
