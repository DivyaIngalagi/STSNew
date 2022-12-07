package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@RequestMapping("/welcome")
	public String loginApplication() {
		return "Welcome to the bank Application";
	}
	
	@RequestMapping("/user/dashboard")
	public String userDashboard() {
		return "Welcome to the user dashboard";
	}
	
	@RequestMapping("/admin/dashboard")
	public String adminDashboard() {
		return "Welcome to the admin dashboard";
	}
}
