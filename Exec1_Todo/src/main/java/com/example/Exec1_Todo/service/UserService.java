package com.example.Exec1_Todo.service;


import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.Mail.MailDto;
import com.example.Exec1_Todo.web.dto.User.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;
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

    public String findEmail(String email){
        try{
            User user = userRepository.findByEmail(email);
            String newPassword = getRandom();
            StringBuilder sb = new StringBuilder();
            user.setPassword(passwordEncoder.encode(newPassword));
            sb.append("회원님의 아이디 : ").append(user.getEmail()).append("\n");
            sb.append("회원님의 비밀번호 : ").append(newPassword).append("\n");
            MailDto mailDto = new MailDto(user.getEmail(),"회원님의 현재 비밀번호 입니다", sb.toString());
            mailService.mailSend(mailDto);
            return "Success";
        }catch(Exception e){
            System.out.println(e);
            return "Fail";
        }
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
//    public UserLoginResponseDto login(UserLoginDto requestDto) {
//        User user = userRepository.findByEmail(requestDto.getEmail());
//        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
//            return new UserLoginResponseDto("Success", user.getId(), user.getEmail(), user.getPassword());
//        } else {
//            return new UserLoginResponseDto("Failure", -1, "", "");
//        }
//    }
    public boolean login(UserLoginDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail());
        System.out.println("_------------");
        System.out.println("UserId : " + user.getEmail());
        System.out.println("REquestPassword : " + requestDto.getPassword());
        System.out.println("UserPassword : " + user.getPassword());
        System.out.println("-------------");
        if(!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            System.out.println("0-00000000");
            System.out.println("tjdrhd");
            System.out.println("-000000000");
            return true;
        }else{
            System.out.println("Failure?");
            return false;
        }
    }
    public UserLoginResponseDto changePassword(UserInfoChangeDto requestDto){
        try {
            User user = userRepository.findById(requestDto.getId());
            user.setPassword(passwordEncoder.encode(requestDto.getNewPassword()));
            return new UserLoginResponseDto("Success", user.getId(),user.getEmail(),user.getPassword());
        }catch(Exception e){
            System.out.println(e.getStackTrace());
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
