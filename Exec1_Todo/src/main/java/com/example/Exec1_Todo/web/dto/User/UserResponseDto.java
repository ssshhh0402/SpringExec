package com.example.Exec1_Todo.web.dto.User;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private long id;
    private String email,password;
    private List<Post> posts;
    private List<CommentResponseDto> comments;

    @Builder
    public UserResponseDto(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.posts = user.getPosts();
        this.comments = user.getComments();
    }
}
