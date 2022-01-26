package com.example.Exec5_NoJpa.web;

import com.example.Exec5_NoJpa.model.dto.user.LoginRequestDto;
import com.example.Exec5_NoJpa.model.dto.user.SignUpRequestDto;
import com.example.Exec5_NoJpa.model.dto.user.UserUpdateRequestDto;
import com.example.Exec5_NoJpa.model.user.User;
import com.example.Exec5_NoJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService a){
        this.userService = a;
    }


    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAllUser();
    }
    @GetMapping("/getUser")
    public User getUserByEmail(@RequestParam("email") String email){
        User user = userService.getUserByEmail(email);
        return user;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto){
        try{
            userService.login(dto);
            if(!userService.login(dto)){
                return new ResponseEntity<>("아이디|비번 불일치", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("성공적으로 로그인이 되었다!!!!!");
        return new ResponseEntity<>("로그인 가능", HttpStatus.OK);
    }

    @GetMapping("/emailCheck")
    public ResponseEntity<Boolean> checkEmail(@RequestParam("email") String email){
        try{
            userService.checkEmail(email);
        }catch(EmptyResultDataAccessException e){
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequestDto dto){
        try{
            return new ResponseEntity<>(userService.signUp(dto), HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/allUser")
    public ResponseEntity<String> deleteAll(){
        try{
            userService.deleteAll();
        }catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOne(@RequestParam long id){
        try{
            userService.deleteOne(id);
        }catch(Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody UserUpdateRequestDto dto){
        try{
            userService.update(dto.getId(), dto.getPwd());
        }catch(Exception e){
            return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
