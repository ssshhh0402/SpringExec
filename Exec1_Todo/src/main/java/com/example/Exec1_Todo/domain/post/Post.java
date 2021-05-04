package com.example.Exec1_Todo.domain.post;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private boolean isDone;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Comment> comments;

    @Builder
    public Post(String email, String contents, Boolean isDone, User user){
        this.email = email;
        this.contents = contents;
        this.isDone = isDone;
        this.user = user;
    }
    public String getEmail(){
        return this.email;
    }
    public String getContents(){
        return this.contents;
    }
    public boolean getIsDone(){
        return this.isDone;
    }
    public List<CommentResponseDto> getComments(){
        List<CommentResponseDto> comments = new ArrayList<CommentResponseDto>();
        for(Comment comment : this.comments){
            comments.add(new CommentResponseDto(comment));
        }
        return comments;
    }
    public void update(PostSaveRequestDto requestDto){
        this.contents = requestDto.getContents();
        this.isDone = requestDto.getIsDone();
    }
}
