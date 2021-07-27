package com.example.Exec1_Todo.service;

import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.post.PostRepository;
import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.Post.PostListResponseDto;
import com.example.Exec1_Todo.web.dto.Post.PostResponseDto;
import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostResponseDto> findAll(){
        List<PostResponseDto> result = new ArrayList<PostResponseDto>();
        List<Post> posts = postRepository.findAll();
            for(Post post : posts){
                result.add(new PostResponseDto(post));
            }
        return result;
    }

    public List<PostResponseDto> findByEmail(String email){
        List<Post> posts = postRepository.findAllByEmail(email);
        List<PostResponseDto> result = new ArrayList<PostResponseDto>();
        for(Post post : posts){
            result.add(new PostResponseDto(post));
        }
        return result;
    }

    public PostResponseDto findOne(long id){
        Post post = postRepository.findById(id);
//        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류가 발생했습니다. 다시 시도해주세요"));
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto save(PostSaveRequestDto requestDto){
        User author = userRepository.findById(requestDto.getUserId());
        Post post = postRepository.save(requestDto.toEntity(author));
        return new PostResponseDto(post);
    }

    public List<PostResponseDto> findByEmailAndIsDone(String email, boolean isDone){
        List<Post> posts = postRepository.findByEmailAndIsDone(email, isDone);
        List<PostResponseDto> result = new ArrayList<PostResponseDto>();
        for(Post post : posts){
            result.add(new PostResponseDto(post));
        }
        return result;
    }

    @Transactional
    public PostResponseDto update(PostSaveRequestDto requestDto, long id){
        Post post = postRepository.findById(id);
//        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("오류가 발생했습니다. 다시 시도해주세요") );
        post.update(requestDto);
        return new PostResponseDto(post);
    }

    @Transactional
    public String deleteAll(){
        try{
            postRepository.deleteAll();
            return "Success";
        }catch(Exception e){
            return "Failure";
        }
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
