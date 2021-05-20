package com.example.Exec1_Todo.web.dto.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoChangeDto {
    public long id;
    public String newPassword;

    public UserInfoChangeDto(long id, String new_p){
        this.id = id;
        this.newPassword = new_p;
    }

    public long getId(){
        return this.id;
    }
    public String getNewPassword(){
        return this.newPassword;
    }
}
