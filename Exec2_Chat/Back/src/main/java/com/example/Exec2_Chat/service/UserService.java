package com.example.Exec2_Chat.service;

import com.example.Exec2_Chat.domain.user.User;
import com.example.Exec2_Chat.domain.user.UserRepository;
import com.example.Exec2_Chat.web.dto.User.UserLoginRequestDto;
import com.example.Exec2_Chat.web.dto.User.UserResponseDto;
import com.example.Exec2_Chat.web.dto.User.UserSaveRequestDto;
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
        return new UserResponseDto(true, user);
    }

    public List<UserResponseDto> getAll(){
        List<UserResponseDto> result = new ArrayList<UserResponseDto>();
        List<User> users = userRepository.findAll();
        for(User user : users){
            result.add(new UserResponseDto(true, user));
        }
        return result;
    }

    public UserResponseDto login(UserLoginRequestDto requestDto){
        User user = userRepository.findByEmail(requestDto.getEmail());
        System.out.println(user);
        if(!passwordEncoder.matches(user.getPassword(), requestDto.getPassword())){
            return new UserResponseDto(true, user);
        }else{
            return new UserResponseDto(false, user);
        }
    }
    public String deleteAll(){
        try{
            userRepository.deleteAll();
            return "Success";
        }catch(Exception e){
            return e.toString();
        }
    }
}
