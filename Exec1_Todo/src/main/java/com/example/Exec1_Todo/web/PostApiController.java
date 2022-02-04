package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.service.PostService;
import com.example.Exec1_Todo.web.dto.Post.PostListResponseDto;
import com.example.Exec1_Todo.web.dto.Post.PostResponseDto;
import com.example.Exec1_Todo.web.dto.Post.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/post")
public class PostApiController {
    private final PostService postService;


    @GetMapping("")
    public ResponseEntity<List<PostResponseDto>> findAllPost(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("sessionId") != null){
            return new ResponseEntity<List<PostResponseDto>>(postService.findAll(), HttpStatus.OK);
        }else{
            List<PostResponseDto> result = null;
            return new ResponseEntity<List<PostResponseDto>>(result, HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> findOne(@PathVariable long id){
        return new ResponseEntity<PostResponseDto>(postService.findOne(id), HttpStatus.OK);
    }
    @GetMapping("/{email}")
    public ResponseEntity<List<PostResponseDto>> findAllByEmail(@PathVariable String email){
        return new ResponseEntity<List<PostResponseDto>>(postService.findByEmail(email), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<PostResponseDto> save(@RequestBody PostSaveRequestDto requestDto){
        return new ResponseEntity<PostResponseDto>(postService.save(requestDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteALl(){
        return new ResponseEntity<String>(postService.deleteAll(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PostResponseDto> update(@RequestBody PostSaveRequestDto requestDto, @PathVariable long id){
        return new ResponseEntity<PostResponseDto>(postService.update(requestDto, id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}/")
    public ResponseEntity<String> delete(@PathVariable long id){
        return new ResponseEntity<String>(postService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{email}/{isDone}/")
    public ResponseEntity<List<PostResponseDto>> findAllByEmailAndIsDone(@PathVariable String email, @PathVariable boolean isDone){
        return new ResponseEntity<List<PostResponseDto>>(postService.findByEmailAndIsDone(email, isDone), HttpStatus.OK);
    }
}
