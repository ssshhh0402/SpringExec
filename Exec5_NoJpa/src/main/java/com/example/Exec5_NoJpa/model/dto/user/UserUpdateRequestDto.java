package com.example.Exec5_NoJpa.model.dto.user;

public class UserUpdateRequestDto {
    private long id;
    private String pwd;
    public UserUpdateRequestDto(){

    }
    public UserUpdateRequestDto(long a, String b){
        this.id = a;
        this.pwd = b;
    }

    public long getId(){
        return this.id;
    }
    public void setId(long a){
        this.id = a;
    }
    public String getPwd(){
        return this.pwd;
    }
    public void setPwd(String a){
        this.pwd = a;
    }
}
