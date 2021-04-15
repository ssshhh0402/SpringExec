package com.example.Exec1_Todo.web.dto;

import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private Long id;
    private String email;
    private String password;



    @Builder
    public UserSaveRequestDto(Long a, String b, String c){
        this.id = a;
        this.email = b;
        this.password = c;
    }

    public User toEntity(){
        return User.builder()
                .userId(this.id)
                .email(this.email)
                .password(this.password)
                .build();
    }


}
