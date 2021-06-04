package com.example.Exec2_Chat.web.dto.User;


import com.example.Exec2_Chat.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String email;
    private String password;

    @Builder
    public UserSaveRequestDto(String a, String b){
        this.email = a;
        this.password = b;
    }

    public User toEntity(String encoded){
        return User.builder()
                .email(this.email)
                .password(encoded)
                .build();
    }
}
