package com.example.Exec5_NoJpa.model.dto.post;

public class PostUpdateRequestDto {
    private long id;
    private String  title,content;

    public PostUpdateRequestDto(){

    }
    public PostUpdateRequestDto(long a, String b, String c){
        this.id = a;
        this.title = b;
        this.content = c;
    }
    public long getId(){
        return this.id;
    }
    public void setId(long a){
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
