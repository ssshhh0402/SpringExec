package com.example.toy.web;

import com.example.toy.domain.user.User;
import com.example.toy.service.UserService;
import com.example.toy.web.Dto.User.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/user")
    public ResponseEntity<UserResponseDto> save(HttpServletRequest request, @RequestBody UserSaveRequestDto requestDto){
        return new ResponseEntity<UserResponseDto>(userService.save(requestDto), HttpStatus.OK);
    }
    @GetMapping("/api/v1/user")
    public ResponseEntity<UserListResponseDto> getAll(){
        return new ResponseEntity<UserListResponseDto>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/user/login")
    public ResponseEntity<UserResponseDto> login(HttpServletRequest request, @RequestBody UserLoginRequestDto requestDto){
        LoginResult lr = userService.login(requestDto);
        if(lr.getResult()){
            HttpSession session = request.getSession(true);
            session.setAttribute("EMAIL", requestDto.getEmail());
            session.setAttribute("PWD" , requestDto.getPassword());
            session.setAttribute("ID", session.getId());
            return new ResponseEntity<UserResponseDto>(new UserResponseDto(lr.getUser()), HttpStatus.OK);
        }else{
            return new ResponseEntity<UserResponseDto>(new UserResponseDto(lr.getUser()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/v1/user/check")
    public ResponseEntity<User> isLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(!session.isNew()){
            User user = new User(session.getAttribute("EMAIL").toString(), session.getAttribute("PWD").toString());
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            User user = new User("","");
            return new ResponseEntity<User>( user, HttpStatus.OK);
        }
    }
    @GetMapping("/api/v1/user/logout")
    public ResponseEntity<Boolean> logout(HttpServletRequest request){
        request.getSession().invalidate();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

}
