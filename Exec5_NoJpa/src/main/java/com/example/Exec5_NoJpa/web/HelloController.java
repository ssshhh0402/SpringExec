package com.example.Exec5_NoJpa.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/v1/hello")
    public String hello(){
        return "HELLO";
    }
}
