package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.model.Doctor;
import com.example.model.Login;
import com.example.model.Patient;
import com.example.model.PatientLogin;

@Repository		
public interface PatientLoginRepository extends CrudRepository<Patient, Integer> {

	
	
	
}
