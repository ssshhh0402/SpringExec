package com.example.Exec5_NoJpa.web;

import com.example.Exec5_NoJpa.jwt.TokenProvider;
import com.example.Exec5_NoJpa.jwt.UserAuthentication;
import com.example.Exec5_NoJpa.model.dto.user.LoginRequestDto;
import com.example.Exec5_NoJpa.model.token.Token;
import com.example.Exec5_NoJpa.model.user.User;
import com.example.Exec5_NoJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(
            final HttpServletRequest req,
            final HttpServletResponse res,
            @RequestBody LoginRequestDto request) throws Exception{
        User user = userService.getUserByEmail(request.getEmail());
        if(user == null){
            throw new IllegalArgumentException("존재하지 않는 유저입니다");
        }else if(!request.getPwd().equals(user.getPwd())){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
        Authentication authentication = new UserAuthentication(request.getEmail(), null,null);
        String token = TokenProvider.generateToken(authentication);
        Token.Response response = new Token.Response(token);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
