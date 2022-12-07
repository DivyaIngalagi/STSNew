package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService userservice;
	
	@PostMapping("/usersave")//only we use it then actual jsp dispalays
	public User saveUser(@RequestBody User user) {
		
		return this.userservice.saveUser(user);
	}
	
	@GetMapping("/usergetAllId")//only we use it then actual jsp dispalays
	public List<User> getAllUser() {
		
		return this.userservice.getAlluser();
	}
	
	@GetMapping("/usergetbyid/{id}")//only we use it then actual jsp dispalays
	public User getUserbyId(@PathVariable int id) {
		
		return this.userservice.getUserById(id);
	}
	
	@DeleteMapping("/userdeletebyid/{id}")
	public void deleteUserbyId(@PathVariable int id) {
		
		this.userservice.deletebyId(id);
	}
	
	@PutMapping("/userupdatebyid")
	public void update(@RequestBody User u) {
		
		this.userservice.updatebyId(u);
	}
}
