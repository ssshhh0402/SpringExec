package com.example.Exec5_NoJpa.service;

import com.example.Exec5_NoJpa.model.dto.post.PostSaveRequestDto;
import com.example.Exec5_NoJpa.model.dto.post.PostUpdateRequestDto;
import com.example.Exec5_NoJpa.model.post.Post;
import com.example.Exec5_NoJpa.model.post.PostRepository;
import com.example.Exec5_NoJpa.model.user.User;
import com.example.Exec5_NoJpa.model.user.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;
    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Post> getAll(){
        return postRepository.getAll();
    }
    public Post findById(long id){
        return postRepository.findById(id);
    }
    public Boolean save(PostSaveRequestDto dto){
        User user = userRepository.findById(dto.getUserId());
        Date time = java.sql.Date.valueOf(LocalDate.now());
        return postRepository.save(dto, user.getEmail(), time);
    }
    public void delete(long id){
        postRepository.delete(id);
    }
    public boolean update(PostUpdateRequestDto dto){
        try{
            Date time = java.sql.Date.valueOf(LocalDate.now());
            postRepository.update(dto.getId(), dto.getTitle(), dto.getContent(), time);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
