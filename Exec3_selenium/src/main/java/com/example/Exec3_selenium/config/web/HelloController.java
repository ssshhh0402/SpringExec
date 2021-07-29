package com.example.Exec3_selenium.config.web;

import com.example.Exec3_selenium.config.service.Seleservice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final Seleservice seleService;
    @GetMapping("/api/v1/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/api/v1/sele")
    public String sele(@RequestParam String id, @RequestParam String pwd){
        seleService.sele(id,pwd);
        return "Success";
    }
}
