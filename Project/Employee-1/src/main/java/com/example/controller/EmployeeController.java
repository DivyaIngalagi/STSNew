package com.example.controller;




	import java.util.Collection;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.model.Employee;
import com.example.service.EmployeeService;

	@RestController
	@RequestMapping("/employee")
	public class EmployeeController {
		

		@Autowired
		EmployeeService empService;


		@GetMapping(value="empList", produces="application/json")
		public Collection<Employee> getAllEmployee(){
		return empService.getAllEmployee();

		}




		}



