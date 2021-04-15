package com.example.Exec1_Todo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/v1/hello")
    public String Hello(){
        return "Hello";
    }
}
