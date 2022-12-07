package com.example.service;

import com.example.model.DoctorLogin;
import com.example.model.Login;

public interface DoctorService {

	public boolean checkDoctorCred(DoctorLogin login);
}
