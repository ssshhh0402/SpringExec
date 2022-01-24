package com.example.Exec5_NoJpa.model.post;

import com.example.Exec5_NoJpa.model.user.User;

public class Post {
    private long id;
    private String title, content, author;
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
}
