package com.example.toy.web.Dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserLoginRequestDto {
    private String email, password;

    @Builder
    public UserLoginRequestDto(String a, String b){
        this.email = a;
        this.password = b;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}

