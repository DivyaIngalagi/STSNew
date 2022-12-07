package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.HospitalRepository;

import com.example.model.Doctor;

@Service
public class HospitalServiceImp implements HospitalService {

	@Autowired(required = true) 
	HospitalRepository userrepo;
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		Doctor doc = userrepo.save(doctor);
		return doc;
	}
	@Override
	@Cacheable(value="doctorCache",key="#id")
	public Optional<Doctor> getDoctorById(int id) {
		return userrepo.findById(id);
	}
	@Override
	public Doctor updateby(Doctor d) {
		Optional<Doctor> doct = userrepo.findById(d.getDocid());
		Doctor d1=doct.get();
		
		Doctor doc = new Doctor();
		  d1.setDocid(d.getDocid());
		  d1.setCity(d.getCity());
		  d1.setAddress(d.getAddress());
		  d1.setEmail(d.getEmail());
		  d1.setFirstName(d.getFirstName());
		  d1.setLastName(d.getLastName());
		  d1.setGender(d.getGender());
		  d1.setMobileno(d.getMobileno());
		  d1.setPassword(d.getPassword());
		  d1.setQualification(d.getQualification());
		  d1.setSpecializaton(d.getSpecializaton());
		  d1.setUsername(d.getUsername());
		  
		return userrepo.save(d1);
		
	 
		
	}
	@Override
	public void deletebyId(int id) {
		userrepo.deleteById(id);
		
	}
	
//	@Cacheable(value="doctorCache")
	public List<Doctor> getAllDoctor() {
		List<Doctor> doctors = (List<Doctor>) userrepo.findAll();
		return doctors;
	}
	


	
}
