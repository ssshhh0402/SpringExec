package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.service.CommentService;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import com.example.Exec1_Todo.web.dto.Comment.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
    final private CommentService commentService;

    @GetMapping("/api/v1/comment/")
    public ResponseEntity<List<CommentResponseDto>> getAll(){
        return new ResponseEntity<List<CommentResponseDto>>(commentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/comment/save/")
    public ResponseEntity<CommentResponseDto> save(@RequestBody CommentSaveRequestDto requestDto){
        return new ResponseEntity<CommentResponseDto>(commentService.save(requestDto), HttpStatus.OK);
    }
}
