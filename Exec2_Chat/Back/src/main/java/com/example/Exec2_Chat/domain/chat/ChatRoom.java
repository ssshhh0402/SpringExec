package com.example.Exec2_Chat.domain.chat;

import com.example.Exec2_Chat.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Entity
@Getter
@NoArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String url;

    @ManyToOne
    @JsonBackReference
    private User user;

    @Builder
    public ChatRoom(String name, User creator){
        this.name =name;
        this.url = getRandomUrl();
        this.user = creator;
    }

    public String getRandomUrl(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 3; i++){
            int n = random.nextInt(3);
            switch(n){
                case 0:
                    sb.append((char)((int)(random.nextInt(26)) + 97));
                    break;
                case 1:
                    sb.append((char)((int)(random.nextInt(26)) + 65));
                    break;
                case 2:
                    sb.append(random.nextInt(10));
                    break;
            }
        }
        return sb.toString();
    }
}
