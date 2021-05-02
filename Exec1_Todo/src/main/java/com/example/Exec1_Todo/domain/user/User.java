package com.example.Exec1_Todo.domain.user;

import com.example.Exec1_Todo.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Post> posts;

    @Builder
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
}
