package com.example.Exec1_Todo.web.dto.Post;

import java.util.ArrayList;
import java.util.List;

public class PostListResponseDto {
    private boolean status;
    private List<PostResponseDto> posts;

    public PostListResponseDto(){
        this.status = false;
        this.posts = new ArrayList<PostResponseDto>();
    }
    public void setStatus(boolean now){
        this.status = now;
    }
    public void setPosts(List<PostResponseDto> now){
        this.posts = now;
    }
    public boolean getStatus(){
        return this.status;
    }
    public List<PostResponseDto> getPosts(){
        return this.posts;
    }
}
