package com.example.Exec1_Todo.service;


import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.User.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserSaveRequestDto requestDto){
        User user = userRepository.save(requestDto.toEntity(requestDto.getPassword()));
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



    public String getRandom(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 10; i++){
            int n = random.nextInt(3);
            switch(n){
                case 0:
                    sb.append((char)((int)(random.nextInt(26)) + 97));
                    break;
                case 1:
                    sb.append((char)((int)(random.nextInt(26)) + 65));
                    break;
                case 2:
                    sb.append(random.nextInt(10));
                    break;
            }
        }
        return sb.toString();
    }
    public boolean login(UserLoginDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail());
        if(requestDto.getPassword().equals(user.getPassword())) {
            return true;
        }else{
            System.out.println("Failure?");
            return false;
        }
    }

    public UserLoginResponseDto changePassword(UserInfoChangeDto requestDto){
        try {
            User user = userRepository.findById(requestDto.getId());
            user.setPassword(requestDto.getNewPassword());
            return new UserLoginResponseDto("Success", user.getId(),user.getEmail(),user.getPassword());
        }catch(Exception e){
            e.getStackTrace();
            return new UserLoginResponseDto("Failure", -1,"","");
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
