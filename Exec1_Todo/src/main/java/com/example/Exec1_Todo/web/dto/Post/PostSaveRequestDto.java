package com.example.Exec1_Todo.web.dto.Post;

import com.example.Exec1_Todo.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String email;
    private String contents;
    private boolean isDone;


    @Builder
    public PostSaveRequestDto(String a, String b, boolean c){
        this.email = a;
        this.contents = b;
        this.isDone = c;
    }

    public Post toEntity(){
        return Post.builder()
                .email(this.email)
                .contents(this.contents)
                .isDone(this.isDone)
                .build();
    }
    public String getContents(){
        return this.contents;
    }
    public boolean getIsDone(){
        return this.isDone;
    }

}
