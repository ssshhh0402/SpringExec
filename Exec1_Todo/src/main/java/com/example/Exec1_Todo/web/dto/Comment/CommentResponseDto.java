package com.example.Exec1_Todo.web.dto.Comment;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;

public class CommentResponseDto {
    private long id;
    private String contents;
    private User user;
    private Post post;

    @Builder
    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.contents = comment.getContents();
        this.user = comment.getUser();
        this.post = comment.getPost();
    }
}
