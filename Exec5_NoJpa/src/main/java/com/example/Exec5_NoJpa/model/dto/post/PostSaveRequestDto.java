package com.example.Exec5_NoJpa.model.dto.post;



public class PostSaveRequestDto {
    private long userId;
    private String title, content;

    public PostSaveRequestDto(){
    }
    public PostSaveRequestDto(String a, String b, long c){
        this.title = a;
        this.content = b;
        this.userId = c;
    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String a){
        this.title = a;
    }
    public long getUserId(){
        return this.userId;
    }
    public void setUserId(long a){
        this.userId = a;
    }
    public String getContent(){
        return this.content;
    }
    public void setContent(String a){
        this.content= a;
    }

}
