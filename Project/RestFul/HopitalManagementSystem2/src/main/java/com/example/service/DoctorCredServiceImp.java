package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminRepository;
import com.example.dao.DoctorLoginRepository;
import com.example.dao.HospitalRepository;
import com.example.dao.PatientRepository;
import com.example.model.Doctor;
import com.example.model.DoctorLogin;
import com.example.model.Login;
import com.example.model.Patient;

@Service
public class DoctorCredServiceImp implements DoctorService {

	@Autowired
	DoctorLoginRepository doctloginrepo;
	
	@Override
	public boolean checkDoctorCred(DoctorLogin login) {
		Optional<Doctor> adcheck = doctloginrepo.findById(login.getId());
		
		if(adcheck.isPresent()) {
			if(adcheck.get().getUsername().equals(login.getLoginUserName())&&adcheck.get().getPassword().equals(login.getLoginPassword())) {
				return true;
			}
		}
		
		return false;
	}

	
}
