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
    private long userId;
    private boolean isDone;


    @Builder
    public PostSaveRequestDto(String a, boolean b, long c){
        this.contents = a;
        this.isDone = b;
        this.userId = c;
    }


    public Post toEntity(User user){
        return Post.builder()
                .email(user.getEmail())
                .contents(this.contents)
                .isDone(this.isDone)
                .user(user)
                .build();
    }
    public long getUserId(){
        return this.userId;
    }
    public String getContents(){
        return this.contents;
    }
    public boolean getIsDone(){
        return this.isDone;
    }

}
