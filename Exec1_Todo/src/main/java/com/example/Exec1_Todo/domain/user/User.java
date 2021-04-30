package com.example.Exec1_Todo.domain.user;

import com.example.Exec1_Todo.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue
    @Column(name="USER_id")
    private Long userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @JoinColumn(name="POST_id")
    private List<Post> posts = new ArrayList<Post>();
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
