package com.example.Exec1_Todo.domain.post;

import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// Entity Dto 분리

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    @Column(name="POST_id")
    private Long postId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private boolean isDone;
    @Builder
    public Post(String email, String contents, Boolean isDone){
        this.email = email;
        this.contents = contents;
        this.isDone = isDone;
    }
    public Long getId(){
        return this.postId;
    }
    public String getEmail(){
        return this.email;
    }
    public String getContents(){
        return this.contents;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
    public void update(PostSaveRequestDto requestDto){
        this.contents = requestDto.getContents();
        this.isDone = requestDto.getIsDone();
    }
}
