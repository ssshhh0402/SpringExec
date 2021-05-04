package com.example.Exec1_Todo.web.dto.Post;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    private long id;
    private String email,contents;
    private boolean isDone;
    private List<CommentResponseDto> comments;

    @Builder
    public PostResponseDto(Post post){
        this.id = post.getId();
        this.email = post.getEmail();
        this.contents = post.getContents();
        this.isDone = post.getIsDone();
        this.comments = post.getComments();
    }
}
