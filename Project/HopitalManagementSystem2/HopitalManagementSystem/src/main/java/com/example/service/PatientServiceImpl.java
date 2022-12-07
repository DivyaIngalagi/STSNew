package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.HospitalRepository;
import com.example.dao.PatientRepository;
import com.example.model.Doctor;
import com.example.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository userrepo;
	@Override
	public boolean savePatient(Patient patient) {
		Patient doc = userrepo.save(patient);
		if(doc!=null) {
			return true;
		}else {
			return false;
		}
	}
//	@Override
//	public Optional<Doctor> getDoctorById(int id) {
//		return userrepo.findById(id);
//	}
//	@Override
//	public boolean updatebyId(Doctor d) {
//		Optional<Doctor> doct = userrepo.findById(d.getDocid());
//		Doctor d1=doct.get();
//		
//		Doctor doc = new Doctor();
//		  d1.setDocid(d.getDocid());
//		  d1.setCity(d.getCity());
//		  d1.setAddress(d.getAddress());
//		  d1.setEmail(d.getEmail());
//		  d1.setFirstName(d.getFirstName());
//		  d1.setLastName(d.getLastName());
//		  d1.setGender(d.getGender());
//		  d1.setMobileno(d.getMobileno());
//		  d1.setPassword(d.getPassword());
//		  d1.setQualification(d.getQualification());
//		  d1.setSpecializaton(d.getSpecializaton());
//		  d1.setUsername(d.getUsername());
//		  
//		userrepo.save(doc);
//		
//		if(doc!=null) {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
//	@Override
//	public void deletebyId(int id) {
//		userrepo.deleteById(id);
//		
//	}
	
//	@Override
//	public List<User> getAlluser() {
//		List<User> users = (List<User>) userrepo.findAll();
//		return users;
//	}

//	@Override
//	public User saveUser(User user) {
//		User u = userrepo.save(user);
//		return u;
//	}

//	@Override
//	public User getUserById(int id) {
//		User u = userrepo.findById(id);
//		return u;
//	}
//
//	@Override
//	public void deletebyId(int id) {
//		userrepo.deleteById(id);
//	}
//
//	@Override
//	public void updatebyId(User u) {
//		User user = userrepo.findById(u.getUid());
//		user.setUid(u.getUid());
//		user.setUname(u.getUname());
//		userrepo.save(user);
//	}



	
}
