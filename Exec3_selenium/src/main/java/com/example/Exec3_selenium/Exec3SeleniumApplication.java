package com.example.Exec3_selenium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exec3SeleniumApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(Exec3SeleniumApplication.class, args);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

}
