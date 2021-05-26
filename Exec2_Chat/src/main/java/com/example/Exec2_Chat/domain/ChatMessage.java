package com.example.Exec2_Chat.domain;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public void setType(MessageType type){
        this.type = type;
    }
    public MessageType getType(){
        return this.type;
    }
    public void setContent(String a){
        this.content = a;
    }
    public String getContent(){
        return this.content;
    }
    public void setSender(String a){
        this.sender = a;
    }
    public String getSender(){
        return this.sender;
    }
}
