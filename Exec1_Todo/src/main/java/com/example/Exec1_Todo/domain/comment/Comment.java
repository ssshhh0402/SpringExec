package com.example.Exec1_Todo.domain.comment;

import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String contents;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    @JsonBackReference
    private Post post;

    @Builder
    public Comment(String contents, User user, Post post){
        this.contents = contents;
        this.user = user;
        this.post = post;
    }

    public User getUser(){
        return this.user;
    }
    public Post getPost(){
        return this.post;
    }
    public String getContents(){
        return this.contents;
    }
}
