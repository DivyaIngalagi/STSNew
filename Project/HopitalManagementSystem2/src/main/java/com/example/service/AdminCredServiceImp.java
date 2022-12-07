package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AdminRepository;
import com.example.dao.HospitalRepository;
import com.example.dao.PatientRepository;
import com.example.model.Doctor;
import com.example.model.Login;
import com.example.model.Patient;

@Service
public class AdminCredServiceImp implements AdminService {

	@Autowired
	AdminRepository adminrepo;
	
	@Override
	public boolean checkAdminCred(Login login) {
		Optional<Login> adcheck = adminrepo.findById()(login.getId());
		
		if(adcheck.isPresent()) {
			if(adcheck.get().getLoginUserName().equals(login.getLoginUserName())&&adcheck.get().getLoginPassword().equals(login.getLoginPassword())) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Login createAdmin(Login alogin) {
		return adminrepo.save(alogin);
		
	}

	
}
