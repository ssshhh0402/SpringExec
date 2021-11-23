package com.example.toy.domain.chat;

public class ChatMessage {
    private String message,sender;
    private MessageType type;

    public String getMessage(){
        return this.message;
    }
    public String getSender(){
        return this.sender;
    }
    public MessageType getType(){
        return this.type;
    }
    public void setMessage(String a){
        this.message = a;
    }
    public void setSender(String a){
        this.sender = a;
    }
    public void setType(MessageType a){
        this.type = a;
    }
    public ChatMessage(){
        this.message = "";
        this.sender = "";
        this.type = null;
    }


}
