package com.example.Exec1_Todo.service;


import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.User.UserLoginDto;
import com.example.Exec1_Todo.web.dto.User.UserResponseDto;
import com.example.Exec1_Todo.web.dto.User.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto save(UserSaveRequestDto requestDto){
        String encoded = passwordEncoder.encode(requestDto.getPassword());
        User user = userRepository.save(requestDto.toEntity(encoded));

        return new UserResponseDto(user);
    }

    @Transactional
    public String deleteAll(){
        try{
            userRepository.deleteAll();
            return "Success";
        }catch(Exception e){
            return "Fail";
        }
    }

    @Transactional
    public String deleteOne(long userId){
        try{
            userRepository.deleteById(userId);
            return "Success";
        }catch(Exception e){
            return "Fail";
        }
    }
    public UserResponseDto findByEmail(String email){
        User user = userRepository.findByEmail(email);
        return new UserResponseDto(user);
    }

    public Boolean login(UserLoginDto requestDto){
        User user = userRepository.findByEmail(requestDto.getEmail());
        if(!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())){
            return true;
        }else{
            return false;
        }
    }

    public List<UserResponseDto> findAll(){
        List<User> users = userRepository.findAll();
        List<UserResponseDto> result = new ArrayList<UserResponseDto>();
        for(User user : users){
            result.add(new UserResponseDto(user));
        }
        return result;
    }
}
