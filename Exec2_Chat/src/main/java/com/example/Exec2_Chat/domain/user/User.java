package com.example.Exec2_Chat.domain.user;

import com.example.Exec2_Chat.domain.chat.ChatRoom;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable=false)
    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    @JsonBackReference
    private List<ChatRoom> created;


    @Builder
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
