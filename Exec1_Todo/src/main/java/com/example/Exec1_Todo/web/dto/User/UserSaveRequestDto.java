package com.example.Exec1_Todo.web.dto.User;

import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String email;
    private String password;


    @Builder
    public UserSaveRequestDto(String b, String c){
        this.email = b;
        this.password = c;
    }

    public User toEntity(String encoded){
        return User.builder()
                .email(this.email)
                .password(encoded)
                .build();
    }

    public String getPassword(){
        return this.password;
    }
}
