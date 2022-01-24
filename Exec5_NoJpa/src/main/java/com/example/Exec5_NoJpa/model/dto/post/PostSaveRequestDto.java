package com.example.Exec5_NoJpa.model.dto.post;

public class PostSaveRequestDto {
    private String title, content;

    public PostSaveRequestDto(){

    }
    public PostSaveRequestDto(String a, String b){
        this.title = a;
        this.content = b;
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
        this.content= a;
    }
}
