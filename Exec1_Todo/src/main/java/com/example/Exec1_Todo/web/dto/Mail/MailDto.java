package com.example.Exec1_Todo.web.dto.Mail;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MailDto {
    private String address;
    private String title;
    private String message;

    public MailDto(String address, String title, String message){
        this.address = address;
        this.title = title;
        this.message = message;
    }
    public String getAddress(){
        return this.address;
    }
    public String getTitle(){
        return this.title;
    }
    public String getMessage(){
        return this.message;
    }
}
