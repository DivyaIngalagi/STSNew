package com.training.app.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.app.model.Physician;

@Repository
public class PhysicianRepository {
	
	public List<Physician> findAll() {
		
		return Arrays.asList(new Physician(101, "Kathy Sierra", "1234567899", "kathy.sierra@gmail.com", Arrays.asList("Orthopedic")), 
				                        new Physician(102, "George King", "4433225566", "george.king@gmail.com", Arrays.asList("Surgeon")));
	}
}
