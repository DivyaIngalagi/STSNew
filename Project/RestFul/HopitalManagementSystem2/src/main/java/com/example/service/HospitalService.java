package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Doctor;

public interface HospitalService {
	public Doctor saveDoctor(Doctor doctor);
//	public List<User> getAlluser();
	public Optional<Doctor> getDoctorById(int id);
	public List<Doctor> getAllDoctor();
	public void deletebyId(int id); 
	public Doctor updateby(Doctor d); 
}
