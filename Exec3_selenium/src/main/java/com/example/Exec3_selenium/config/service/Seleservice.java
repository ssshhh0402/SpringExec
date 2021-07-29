package com.example.Exec3_selenium.config.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Seleservice {
    public void sele(String id, String pwd){
        Selenium sel = new Selenium(id, pwd);
    }
}
