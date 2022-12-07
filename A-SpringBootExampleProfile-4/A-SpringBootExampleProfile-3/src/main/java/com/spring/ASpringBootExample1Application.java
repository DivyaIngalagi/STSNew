package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.model.Deparement;
import com.spring.model.Developer;

@SpringBootApplication
public class ASpringBootExample1Application implements CommandLineRunner{

	@Autowired
	
	private Deparement dept;                                                                                     //2ndmethod
//	private Developer developer;                                                                                 //1stmethod
	
	public static void main(String[] args) {
		SpringApplication.run(ASpringBootExample1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
     	dept.Operation();                                                                                        //2ndmethod	
//		developer.Operation();                                                                                   //1stmethod
	}
	
//	 @Bean public Developer developer() { return new Developer(); }                                              //1stmethod
	 

}
