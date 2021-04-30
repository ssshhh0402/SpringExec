package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.service.PostService;
import com.example.Exec1_Todo.web.dto.Post.PostResponseDto;
import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;


    @GetMapping("/api/v1/post/")
    public ResponseEntity<List<PostResponseDto>> findAllPost(){
        return new ResponseEntity<List<PostResponseDto>>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/post/{email}/")
    public ResponseEntity<List<PostResponseDto>> findAllByEmail(@PathVariable String email){
        return new ResponseEntity<List<PostResponseDto>>(postService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/api/v1/post/")
    public ResponseEntity<PostResponseDto> save(@RequestBody PostSaveRequestDto requestDto){
        return new ResponseEntity<PostResponseDto>(postService.save(requestDto), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/post/delete")
    public ResponseEntity<String> deleteALl(){
        return new ResponseEntity<String>(postService.deleteAll(), HttpStatus.OK);
    }
    @PutMapping("/api/v1/post/update/{id}")
    public ResponseEntity<PostResponseDto> update(@RequestBody PostSaveRequestDto requestDto, @PathVariable long id){
        return new ResponseEntity<PostResponseDto>(postService.update(requestDto, id), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/post/delete/{id}/")
    public ResponseEntity<String> delete(@PathVariable long id){
        return new ResponseEntity<String>(postService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/api/v1/post/{email}/{isDone}/")
    public ResponseEntity<List<PostResponseDto>> findAllByEmailAndIsDone(@PathVariable String email, @PathVariable boolean isDone){
        return new ResponseEntity<List<PostResponseDto>>(postService.findByEmailAndIsDone(email, isDone), HttpStatus.OK);
    }
}
