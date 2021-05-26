package com.example.Exec2_Chat.domain;

public class ChatMessage {
    private MessageType messageType;
    private String content;
    private String sender;

    public void setMessageType(MessageType type){
        this.messageType = type;
    }
    public MessageType getMessageType(){
        return this.messageType;
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
