package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Doctor;

public interface HospitalService {
	public boolean saveDoctor(Doctor doctor);
//	public List<User> getAlluser();
	public Optional<Doctor> getDoctorById(int id);
	public List<Doctor> getAllDoctor();
	public void deletebyId(int id); 
	public boolean updatebyId(Doctor d); 
}
