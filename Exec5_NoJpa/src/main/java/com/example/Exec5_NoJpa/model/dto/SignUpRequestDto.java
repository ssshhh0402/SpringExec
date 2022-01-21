package com.example.Exec5_NoJpa.model.dto;

public class SignUpRequestDto {
    private String email, pwd;

    public SignUpRequestDto(){

    }
    public SignUpRequestDto(String a, String b){
        this.email = a;
        this.pwd = b;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String a){
        this.email = a;
    }
    public String getPwd(){
        return this.pwd;
    }
    public void setPwd(String a){
        this.pwd = a;
    }

}
