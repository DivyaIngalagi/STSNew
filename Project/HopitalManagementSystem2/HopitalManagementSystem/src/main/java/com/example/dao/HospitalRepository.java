package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Doctor;

@Repository		
public interface HospitalRepository extends CrudRepository<Doctor, Integer> {

	
	
	
}
