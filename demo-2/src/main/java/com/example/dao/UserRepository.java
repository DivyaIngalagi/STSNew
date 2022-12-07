package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository		
public interface UserRepository extends CrudRepository<User, Integer> {

	
	public User findById(int id);
	
}
