package com.example.toy.domain.chat;
//Entity화 하기
public class ChatMessage {
    // 유저랑 1:1 관계 설정
    private String message,sender;
    private MessageType type;
    private Long roomId;
    public String getMessage(){
        return this.message;
    }
    public String getSender(){
        return this.sender;
    }
    public Long getRoomId(){
        return this.roomId;
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
    public void setRoomId(Long a){
        this.roomId = a;
    }
    public void setType(MessageType a){
        this.type = a;
    }
    public ChatMessage(){
        this.message = null;
        this.sender = null;
        this.roomId = null;
        this.type = null;
    }


}
