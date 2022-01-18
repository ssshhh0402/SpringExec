package com.example.Exec5_NoJpa.model.dto;

public class UserDto {
    private int id;
    private String email, pwd;

    public UserDto(int a, String b, String c){
        this.id = a;
        this.email = b;
        this.pwd = c;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int a){
        this.id = a;
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
