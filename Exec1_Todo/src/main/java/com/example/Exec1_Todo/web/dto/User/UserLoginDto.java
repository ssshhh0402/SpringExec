package com.example.Exec1_Todo.web.dto.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginDto {
    private String email, password;

    @Builder
    public UserLoginDto(String a, String b){
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
