package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Doctor;
import com.example.model.Login;
import com.example.model.Patient;

@Repository		
public interface AdminRepository extends CrudRepository<Login, Integer> {

	
	
	
}
