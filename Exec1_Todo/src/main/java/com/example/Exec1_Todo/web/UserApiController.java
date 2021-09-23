package com.example.Exec1_Todo.web;

import com.example.Exec1_Todo.service.UserService;
import com.example.Exec1_Todo.web.dto.User.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @DeleteMapping("/api/v1/user/delete")
    public ResponseEntity<String> deleteAll(HttpServletRequest request){

        return new ResponseEntity<String>(userService.deleteAll(), HttpStatus.OK);
    }
    @DeleteMapping("/api/v1/user/delete/{userId}")
    public ResponseEntity<String> deleteOne( @PathVariable long userId){
        return new ResponseEntity<String>(userService.deleteOne(userId), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/")
    public ResponseEntity<List<UserResponseDto>> findAllUser(){
        return new ResponseEntity<List<UserResponseDto>>(userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/find/{email}")
    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email){
        return new ResponseEntity<UserResponseDto>(userService.findByEmail(email), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user/find/send/{email}")
    public ResponseEntity<String> findEmail(@PathVariable String email){

        return new ResponseEntity<String>(userService.findEmail(email), HttpStatus.OK);
    }
    @PostMapping("/api/v1/user")
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto requestDto){
        return new ResponseEntity<UserResponseDto>(userService.save(requestDto), HttpStatus.OK);
    }
//    @PostMapping("/api/v1/user/login")
//    public ResponseEntity<UserLoginResponseDto> login(HttpServletRequest request, @RequestBody UserLoginDto requestDto){
//        System.out.println(request);
//        return new ResponseEntity<UserLoginResponseDto>(userService.login(requestDto), HttpStatus.OK);
//    }
    @PostMapping("/api/v1/user/login")
    public String login(HttpServletRequest request, @RequestBody UserLoginDto requestDto){
        if(userService.login(requestDto)){
            HttpSession session = request.getSession();
            session.setAttribute("sessionId", requestDto.getEmail());
            return "Success";
        }else{
            return "Fail";
        }
//        return new ResponseEntity<UserLoginResponseDto>(userService.login(requestDto), HttpStatus.OK);
    }

    @GetMapping("/api/v1/user/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("sessionId") != null){
            session.invalidate();
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("api/v1/user/change")
    public ResponseEntity<UserLoginResponseDto> change(@RequestBody UserInfoChangeDto requestDto){
        return new ResponseEntity<UserLoginResponseDto>(userService.changePassword(requestDto), HttpStatus.OK);
    }
}
