package com.example.Exec5_NoJpa.web;

import com.example.Exec5_NoJpa.model.dto.post.PostSaveRequestDto;
import com.example.Exec5_NoJpa.model.post.Post;
import com.example.Exec5_NoJpa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("")
    public ResponseEntity<List<Post>> getAll(){
        try{
            return new ResponseEntity<List<Post>>(postService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")
    public ResponseEntity<Post> getById(@RequestParam long id){
        try{
            return new ResponseEntity<Post>(postService.findById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(@RequestParam PostSaveRequestDto dto){
        try{
            return new ResponseEntity<Boolean>(postService.save(dto), HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
