package com.example.Exec1_Todo.service;

import com.example.Exec1_Todo.domain.comment.Comment;
import com.example.Exec1_Todo.domain.comment.CommentRepository;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    private final CommentRepository commentRepository;


    public List<CommentResponseDto> getAll(){
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> result = new ArrayList<CommentResponseDto>();
        for(Comment comment : comments){
            result.add(new CommentResponseDto(comment));
        }
        return result;
    }
}
