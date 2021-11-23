package com.example.toy.web.Dto.User;

import com.example.toy.domain.user.User;
import lombok.Getter;

@Getter
public class LoginResult {
    private boolean result;
    private User user;

    public LoginResult(boolean a, User b){
        this.result = a;
        this.user = b;
    }

    public boolean getResult(){
        return this.result;
    }
    public User getUser(){
        return this.user;
    }

}
