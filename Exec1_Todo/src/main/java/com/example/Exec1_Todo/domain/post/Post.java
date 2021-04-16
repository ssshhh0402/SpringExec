package com.example.Exec1_Todo.domain.post;

import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    private Long postId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private boolean isDone;
    @Builder
    public Post(Long postId, String email, String contents, Boolean isDone){
        this.postId = postId;
        this.email = email;
        this.contents = contents;
        this.isDone = isDone;
    }
    public Long getId(){
        return this.postId;
    }

    public void update(PostSaveRequestDto requestDto){
        this.contents = requestDto.getContents();
        this.isDone = requestDto.getIsDone();
    }
}
