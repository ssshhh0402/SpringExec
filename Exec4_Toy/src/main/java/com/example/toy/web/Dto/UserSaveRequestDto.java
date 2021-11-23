package com.example.toy.web.Dto;

import com.example.toy.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSaveRequestDto {
    private String email, password;
    @Builder
    public UserSaveRequestDto(String a, String b){
        this.email = a;
        this.password = b;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }
}
