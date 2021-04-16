package com.example.Exec1_Todo.service;

import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.post.PostRepository;
import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public List<Post> findByEmail(String email){
        return postRepository.findAllByEmail(email);
    }

    @Transactional
    public Post save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity());
    }
    public List<Post> findByEmailAndIsDone(String email, boolean isDone){
        return postRepository.findByEmailAndIsDone(email, isDone);

    }
    @Transactional
    public Post update(PostSaveRequestDto requestDto){
        long id = requestDto.getId();
        Post newOne = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류가 발생했습니다. 다시 시도해주세요") );
        newOne.update(requestDto);
        return newOne;
    }

    @Transactional
    public String delete(long id){
        try{
            postRepository.deleteById(id);
            return "Success";
        }catch(Exception e){
            return "Fail";
        }
    }





}
