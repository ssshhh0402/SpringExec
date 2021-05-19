package com.example.Exec1_Todo.web.dto.Comment;
import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
public class SubCommentSaveRequestDto {
    long userId, postId, superId;
    String contents;

    public SubCommentSaveRequestDto(long a, long b, long c, String d){
        this.userId = a;
        this.postId = b;
        this.superId = c;
        this.contents = d;
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
    public Comment toEntity(User user, Post post, Comment comment){
        return Comment.builder()
                .user(user)
                .post(post)
                .contents(this.contents)
                .superComments(comment)
                .build();
    }
}
