package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.domain.post.Post;
import com.example.Exec1_Todo.service.PostService;
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
    public ResponseEntity<List<Post>> findAllPost(){
        return new ResponseEntity<List<Post>>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/post/{email}/")
    public ResponseEntity<List<Post>> findAllByEmail(@PathVariable String email){
        return new ResponseEntity<List<Post>>(postService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/api/v1/post/")
    public ResponseEntity<Post> save(@RequestBody PostSaveRequestDto requestDto){
        return new ResponseEntity<Post>(postService.save(requestDto), HttpStatus.OK);
    }

    @PostMapping("/api/v1/post/update/")
    public ResponseEntity<Post> update(@RequestBody PostSaveRequestDto requestDto){
        return new ResponseEntity<Post>(postService.update(requestDto), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/post/delete/{id}/")
    public ResponseEntity<String> delete(@PathVariable long id){
        return new ResponseEntity<String>(postService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/api/v1/post/{email}/{isDone}/")
    public ResponseEntity<List<Post>> findAllByEmailAndIsDone(@PathVariable String email, @PathVariable boolean isDone){
        return new ResponseEntity<List<Post>>(postService.findByEmailAndIsDone(email, isDone), HttpStatus.OK);
    }
}
