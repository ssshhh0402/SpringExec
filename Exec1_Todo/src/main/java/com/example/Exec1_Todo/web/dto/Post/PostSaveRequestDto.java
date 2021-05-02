package com.example.Exec1_Todo.web.dto.Post;

import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String contents;
    private User user;
    private boolean isDone;


    @Builder
    public PostSaveRequestDto(String a, boolean b, User user){
        this.user = user;
        this.contents = a;
        this.isDone = b;
    }

    public Post toEntity(){
        return Post.builder()
                .email(this.user.getEmail())
                .contents(this.contents)
                .isDone(this.isDone)
                .user(this.user)
                .build();
    }
    public String getContents(){
        return this.contents;
    }
    public boolean getIsDone(){
        return this.isDone;
    }

}
