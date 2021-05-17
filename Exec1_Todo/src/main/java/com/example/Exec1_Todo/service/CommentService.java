package com.example.Exec1_Todo.service;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.comment.CommentRepository;
import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.domain.post.PostRepository;
import com.example.Exec1_Todo.domain.user.User;
import com.example.Exec1_Todo.domain.user.UserRepository;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import com.example.Exec1_Todo.web.dto.Comment.CommentSaveRequestDto;
import com.example.Exec1_Todo.web.dto.Comment.RecommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
            result.add(new CommentResponseDto(comment));
        }
        return result;
    }

    public CommentResponseDto save(CommentSaveRequestDto requestDto) {
        User author = userRepository.findById(requestDto.getUserId());
        Post post = postRepository.findById(requestDto.getPostId());
//        Post post = postRepository.findById(requestDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("Post"));
        Comment result = commentRepository.save(requestDto.toEntity(author, post));
        return new CommentResponseDto(result);
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

    public CommentResponseDto resave(RecommentSaveRequestDto requestDto) {
        User author = userRepository.findById(requestDto.getUserId());
        Post post = postRepository.findById(requestDto.getPostId());
        Comment supers = commentRepository.findById(requestDto.getSuperId());
        Comment result = commentRepository.save(requestDto.toEntity(author, post, supers));
        return new CommentResponseDto(result);
    }
}
