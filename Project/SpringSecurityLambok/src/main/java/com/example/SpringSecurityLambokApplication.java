package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Student;

@SpringBootApplication
public class SpringSecurityLambokApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityLambokApplication.class, args);
		Student s =new Student();
		s.setSid(10);
		s.setSname("divya");
		System.out.println(s.toString());
	}

}
