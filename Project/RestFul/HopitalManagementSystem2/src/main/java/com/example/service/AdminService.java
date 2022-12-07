package com.example.service;

import com.example.model.Login;

public interface AdminService {

	public boolean checkAdminCred(Login login);

	public Login createAdmin(Login alogin);
}
