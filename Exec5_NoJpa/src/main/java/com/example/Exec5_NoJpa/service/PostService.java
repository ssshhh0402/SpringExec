package com.example.Exec5_NoJpa.service;

import com.example.Exec5_NoJpa.model.dto.post.PostSaveRequestDto;
import com.example.Exec5_NoJpa.model.post.Post;
import com.example.Exec5_NoJpa.model.post.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getAll(){
        return postRepository.getAll();
    }
    public Post findById(long id){
        return postRepository.findById(id);
    }
    public Boolean save(PostSaveRequestDto dto){
        return postRepository.save(dto);
    }
}
