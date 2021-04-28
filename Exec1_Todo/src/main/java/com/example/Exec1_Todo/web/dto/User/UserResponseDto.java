package com.example.Exec1_Todo.web.dto.User;

import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private long userId;
    private String email,password;

    @Builder
    public UserResponseDto(User user){
        this.userId = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
