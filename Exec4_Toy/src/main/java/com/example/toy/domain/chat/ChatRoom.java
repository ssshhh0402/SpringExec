package com.example.toy.domain.chat;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;
    @Builder
    public ChatRoom(String a){
        this.name = a;
    }
    public String getName(){
        return this.name;
    }
    public long getId(){
        return this.id;
    }
}
