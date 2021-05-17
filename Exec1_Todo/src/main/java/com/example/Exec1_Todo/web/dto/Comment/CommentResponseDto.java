package com.example.Exec1_Todo.web.dto.Comment;

import com.example.Exec1_Todo.domain.comment.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private long id;
    private String contents;
    private String userEmail;
    private long postId, userId;
    private List<Comment> subComments;
    @Builder
    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.userId = comment.getUser().getId();
        this.postId = comment.getPost().getId();
        this.contents = comment.getContents();
        this.userEmail = comment.getUser().getEmail();
        this.subComments = comment.getSubComments();
    }
}
