package com.example.toy.domain.chat;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ChatRoom {
    // 유저랑 M:N 관계 설정하기
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Builder
    public ChatRoom(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public long getId(){
        return this.id;
    }
}
