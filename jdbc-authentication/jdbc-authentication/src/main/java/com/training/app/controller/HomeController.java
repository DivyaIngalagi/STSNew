package com.training.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
	
	@GetMapping("/greet/{name}")
	public ResponseEntity<String> greet(@PathVariable String name) {
		return ResponseEntity.ok("Hello, " + name);
	}
	
	@GetMapping("/")
	public String homePage() {
		return "<h3>Welcome Page</h3>";
	}
	
	@GetMapping("/user/dashboard")
	public String userDashboard() {
		return "<h3>Welcome User</h3>";
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "<h3>Welcome admin</h3>";
	}
}
