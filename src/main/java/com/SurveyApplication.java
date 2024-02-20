package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class SurveyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyApplication.class, args); 
		System.out.println("Application Is Running******************");
	}

} 
