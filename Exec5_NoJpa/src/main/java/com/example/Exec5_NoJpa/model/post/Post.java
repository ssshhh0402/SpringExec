package com.example.Exec5_NoJpa.model.post;

import com.example.Exec5_NoJpa.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

public class Post {
    private long id;
    private String title, content, author;
    @DateTimeFormat(pattern="yyyy-MM-dd`T`HH:mm:ss")
    private LocalDate times;
    public Post(){

    }
    public Post(long a, String b, String c, String d){
        this.id = a;
        this.title = b;
        this.content= c;
        this.author = d;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setAuthor(String a){
        this.author = a;
    }
    public long getId(){
        return this.id;
    }
    public void setId(int a){
        this.id = a;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String a){
        this.title = a;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String a){
        this.content = a;
    }
    public Date getTimes() {
        return java.sql.Date.valueOf(this.times);
    }
    public void setTimes(Date a){
        this.times = a.toLocalDate();
    }
}
