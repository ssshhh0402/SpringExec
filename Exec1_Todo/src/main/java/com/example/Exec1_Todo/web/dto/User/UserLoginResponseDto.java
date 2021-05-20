package com.example.Exec1_Todo.web.dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLoginResponseDto {
    private String status;
    private long userId;
    private String userEmail,userPassword;



    public UserLoginResponseDto(String status, long userId, String email, String password){
        this.status = status;
        this.userId = userId;
        this.userEmail = email;
        this.userPassword = password;
    }
}
