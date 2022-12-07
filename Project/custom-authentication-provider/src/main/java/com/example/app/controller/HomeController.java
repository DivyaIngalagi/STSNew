package com.example.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

//	@GetMapping("/greet/{name}")
//	public ResponseEntity<String> greet(@PathVariable String name){
//		return ResponseEntity.ok("Hello,"+name);
//	}
	
	@GetMapping("/data")
	public String data() {
		return "This is confidential data";
	}
	
//	@GetMapping("/")
//	public String homePage() {
//		return "Welecome Page";
//	}
//	
//	@GetMapping("/user/dashboard")
//	public String userDashboard() {
//		return "Welecome User";
//	}
//	
//	@GetMapping("/admin/dashboard")
//	public String adminDashboard() {
//		return "Welecome Admin";
//	}
}
