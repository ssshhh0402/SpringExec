package com.example.Exec2_Chat.web.dto.User;

import kotlin.BuilderInference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequestDto {
    String email;
    String password;

    @Builder
    public UserLoginRequestDto(String a, String b){
        this.email = a;
        this.password = b;
    }
}
