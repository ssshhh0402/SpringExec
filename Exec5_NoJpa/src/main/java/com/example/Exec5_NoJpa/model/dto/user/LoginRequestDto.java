package com.example.Exec5_NoJpa.model.dto.user;

public class LoginRequestDto {
    private String email, pwd;
    public LoginRequestDto(){

    }
    public LoginRequestDto(String a, String b){
        this.email = a;
        this.pwd = b;
    }

    public String getEmail(){
        return this.email;
    }
    public void SetEmail(String a){
        this.email = a;
    }
    public String getPwd(){
        return this.pwd;
    }
    public void setPwd(String a){
        this.pwd = a;
    }
}
