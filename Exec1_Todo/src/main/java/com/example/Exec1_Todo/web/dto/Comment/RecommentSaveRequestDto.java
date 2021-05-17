package com.example.Exec1_Todo.web.dto.Comment;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RecommentSaveRequestDto {
    long userId, postId, superId;
    String contents;

    @Builder
    public RecommentSaveRequestDto(long a, long b, long c, String d){
        this.userId = a;
        this.postId = b;
        this.superId = c;
        this.contents = d;
    }

    public Comment toEntity(User user, Post post, Comment superComments){
        return Comment.builder()
                .contents(this.contents)
                .user(user)
                .post(post)
                .superComments(superComments)
                .build();

    }

    public long getUserId(){
        return this.userId;
    }
    public long getPostId(){
        return this.postId;
    }
    public long getSuperId(){
        return this.superId;
    }
}
