package com.example.Exec2_Chat.domain.chat;

public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String roomId;

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
    public String getRoomId(){
        return this.roomId;
    }
    public void setRoomId(String a){
        this.roomId = a;
    }
}
