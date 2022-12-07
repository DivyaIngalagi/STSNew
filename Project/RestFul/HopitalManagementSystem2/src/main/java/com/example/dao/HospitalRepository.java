package com.example.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Doctor;

@Repository		
public interface HospitalRepository extends CrudRepository<Doctor, Integer> {

	
	
	
}
