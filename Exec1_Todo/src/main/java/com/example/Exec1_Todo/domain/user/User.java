package com.example.Exec1_Todo.domain.user;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Comment> comments;

    @Builder
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public List<Post> getPosts(){
        return this.posts;
    }
    public List<CommentResponseDto> getComments(){
        List<CommentResponseDto> comments = new ArrayList<CommentResponseDto>();
        if(this.comments != null) {
            for (Comment comment : this.comments) {
                List<CommentResponseDto> subs = new ArrayList<CommentResponseDto>();
                for(Comment sub : comment.getSubComments()){
                    subs.add(findSubs(sub));
                }
                comments.add(new CommentResponseDto(comment, subs));
            }
        }
        return comments;
    }
    public CommentResponseDto findSubs(Comment target){
        List<CommentResponseDto> subs = new ArrayList<CommentResponseDto>();
        for(Comment comment : target.getSubComments()){
            subs.add(findSubs(comment));
        }
        return new CommentResponseDto(target, subs);
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

}
