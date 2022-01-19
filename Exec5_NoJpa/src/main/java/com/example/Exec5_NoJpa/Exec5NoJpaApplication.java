package com.example.Exec5_NoJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exec5NoJpaApplication {
	public static void main(String[] args) {
		try{
			SpringApplication.run(Exec5NoJpaApplication.class, args);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
