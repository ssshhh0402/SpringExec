package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.service.CommentService;
import com.example.Exec1_Todo.web.dto.Comment.CommentResponseDto;
import com.example.Exec1_Todo.web.dto.Comment.CommentSaveRequestDto;
import com.example.Exec1_Todo.web.dto.Comment.SubCommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentApiController {
    private final CommentService commentService;

    @GetMapping("/api/v1/comment/")
    public ResponseEntity<List<CommentResponseDto>> getAll(){
        return new ResponseEntity<List<CommentResponseDto>>(commentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/comment/save/")
    public ResponseEntity<CommentResponseDto> save(@RequestBody CommentSaveRequestDto requestDto){
        return new ResponseEntity<CommentResponseDto>(commentService.save(requestDto), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/comments/delete/{id}/")
    public ResponseEntity<String> deleteOne(@PathVariable long id){
        return new ResponseEntity<String>(commentService.delete(id), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/comments/deleteAll/")
    public ResponseEntity<String> deleteAll(){
        return new ResponseEntity<String>(commentService.deleteAll(), HttpStatus.OK);
    }
    @PutMapping("/api/v1/comments/recomment/")
    public ResponseEntity<CommentResponseDto> recomments(@RequestBody SubCommentSaveRequestDto requestDto){
        return new ResponseEntity<CommentResponseDto> (commentService.resave(requestDto), HttpStatus.OK);
    }
}
