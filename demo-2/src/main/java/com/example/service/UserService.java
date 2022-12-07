package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	public User saveUser(User user);
	public List<User> getAlluser();
	public User getUserById(int id);
	public void deletebyId(int id); 
	public void updatebyId(User u); 
}
