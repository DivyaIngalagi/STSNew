package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserRepository;
import com.example.entity.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userrepo;
	
	@Override
	public List<User> getAlluser() {
		List<User> users = (List<User>) userrepo.findAll();
		return users;
	}

	@Override
	public User saveUser(User user) {
		User u = userrepo.save(user);
		return u;
	}

	@Override
	public User getUserById(int id) {
		User u = userrepo.findById(id);
		return u;
	}

	@Override
	public void deletebyId(int id) {
		userrepo.deleteById(id);
	}

	@Override
	public void updatebyId(User u) {
		User user = userrepo.findById(u.getUid());
		user.setUid(u.getUid());
		user.setUname(u.getUname());
		userrepo.save(user);
	}

	
}
