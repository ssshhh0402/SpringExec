package com.example.Exec1_Todo.web.dto.Post;

import com.example.Exec1_Todo.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private long id;
    private String email, contents;
    private boolean isDone;


    @Builder
    public PostSaveRequestDto(long a, String b, String c, boolean d){
        this.id = a;
        this.email = b;
        this.contents = c;
        this.isDone = d;
    }

    public Post toEntity(){
        return Post.builder()
                .postId(this.id)
                .email(this.email)
                .contents(this.contents)
                .isDone(this.isDone)
                .build();
    }
    public long getId(){
        return this.id;
    }

    public String getContents(){
        return this.contents;
    }
    public boolean getIsDone(){
        return this.isDone;
    }

}
