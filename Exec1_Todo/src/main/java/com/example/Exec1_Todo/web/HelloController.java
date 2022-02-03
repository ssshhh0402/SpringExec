package com.example.Exec1_Todo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/v1/hello")
    public String Hello(){
        System.out.println("_________________HELLO_________________________");
        System.out.println("!!!!!!!!!!!!!!!!!ISITWORK?!?!!!!!!!!!!!!!!!!!!!!");
        return "Hello";
    }
}
