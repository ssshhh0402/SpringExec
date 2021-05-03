package com.example.Exec1_Todo.web.dto.Comment;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private long userId, postId;
    private String contents;

    @Builder
    public CommentSaveRequestDto(long a, long b, String c){
        this.userId = a;
        this.postId = b;
        this.contents = c;
    }
    public Comment toEntity(User user, Post post){
        return Comment.builder()
                .contents(this.contents)
                .user(user)
                .post(post)
                .build();
    }

    public long getUserId(){
        return this.userId;
    }
    public long getPostId(){
        return this.postId;
    }
}
