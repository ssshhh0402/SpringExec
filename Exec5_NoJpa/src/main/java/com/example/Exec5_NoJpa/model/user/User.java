package com.example.Exec5_NoJpa.model.user;

public class User {
    private int id;
    private String email, pwd;
    public User(){

    }
    public User(int a, String b, String c){
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
