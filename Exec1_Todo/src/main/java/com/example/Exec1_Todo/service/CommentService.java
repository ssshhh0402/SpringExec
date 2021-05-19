package com.example.Exec1_Todo.service;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.comment.CommentRepository;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.post.PostRepository;
import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import com.example.Exec1_Todo.web.dto.Comment.CommentSaveRequestDto;
import com.example.Exec1_Todo.web.dto.Comment.SubCommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public List<CommentResponseDto> getAll() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> result = new ArrayList<CommentResponseDto>();
        for (Comment comment : comments) {
            List<CommentResponseDto> subs = new ArrayList<CommentResponseDto>();
            for(Comment sub : comment.getSubComments()){
                subs.add(getSub(sub));
            }
            result.add(new CommentResponseDto(comment, subs));
        }
        return result;
    }
    public CommentResponseDto getSub(Comment target){
        List<CommentResponseDto> subs = new ArrayList<CommentResponseDto>();
        for (Comment sub : target.getSubComments()){
            subs.add(getSub(sub));
        }
        return new CommentResponseDto(target, subs);
    }
    public CommentResponseDto save(CommentSaveRequestDto requestDto) {
        User author = userRepository.findById(requestDto.getUserId());
        Post post = postRepository.findById(requestDto.getPostId());
//        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("Post"));
        Comment result = commentRepository.save(requestDto.toEntity(author, post));
        List<CommentResponseDto> lists = new ArrayList<CommentResponseDto>();
        return new CommentResponseDto(result, lists);
    }

    public String delete(long id) {
        try {
            commentRepository.deleteById(id);
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }
    }

    public String deleteAll() {
        try {
            commentRepository.deleteAll();
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }
    }

    public CommentResponseDto resave(SubCommentSaveRequestDto requestDto) {
        User author = userRepository.findById(requestDto.getUserId());
        Post post = postRepository.findById(requestDto.getPostId());
        Comment supers = commentRepository.findById(requestDto.getSuperId());
        Comment result = commentRepository.save(requestDto.toEntity(author, post, supers));
        List<CommentResponseDto> lists = new ArrayList<CommentResponseDto>();
        return new CommentResponseDto(result, lists);
    }
}
