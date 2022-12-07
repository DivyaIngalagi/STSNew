package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeRepository;
import com.example.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	
	
	public Collection<Employee> getAllEmployee() {
		
		return emprepo.findAll();
	}
	

}
