package com.example.toy.web.Dto.User;

import com.example.toy.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserResponseDto {

    private String email;
    private String password;
    @Builder
    public UserResponseDto(User user){
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
