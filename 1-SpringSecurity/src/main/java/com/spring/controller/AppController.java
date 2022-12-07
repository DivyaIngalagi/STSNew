package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	
	@RequestMapping("/welcome")
	public String loginInApplication()
	{
		return "Welcome to the Bank Application";
	}
	
	
	@RequestMapping("/user/dashboard")
	public String userDashboard()
	{
		return "<h5>Welcome to the User Dashboard</h5>";
	}
	
	
	@RequestMapping("/admin/dashboard")
	public String adminDashboard()
	{
		return "<h5>Welcome to the Admin Dashboard</h5>";
	}
}
