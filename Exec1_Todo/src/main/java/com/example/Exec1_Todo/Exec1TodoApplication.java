package com.example.Exec1_Todo;

import org.springframework.boot.SpringApplication;
import org.springframework.core.SpringVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exec1TodoApplication {

	public static void main(String[] args) {
		System.out.println("+++++++++++"+SpringVersion.getVersion());
		SpringApplication.run(Exec1TodoApplication.class, args);
	}

}
