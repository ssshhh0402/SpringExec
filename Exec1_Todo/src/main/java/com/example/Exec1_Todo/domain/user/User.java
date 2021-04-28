package com.example.Exec1_Todo.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public long getId(){return this.userId;}
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
