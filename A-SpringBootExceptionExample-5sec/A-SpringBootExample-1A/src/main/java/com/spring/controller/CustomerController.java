package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Customer;
import com.spring.service.CustomerService;

@RestController
public class CustomerController {

	
	@Autowired
	CustomerService service;
	
	
	@GetMapping("/try")
	
	public String loadJsp()
	{
		return "welcomepage";
	}
	
	@RequestMapping(value="/customer",method=RequestMethod.POST)
	//@PostMapping("/customer")
	public Customer  addCustomer(@RequestBody Customer customer) {
		Customer cust=service.SaveCustomer(customer);
		
		return cust;
		
	}
	
	
	/*
	 * @PutMapping("/customer") public Customer UpdateCustomer(@RequestBody Customer
	 * customer) { Customer cust=service.updateCustomer(customer);
	 * 
	 * return cust;
	 * 
	 * }
	 */
	
    @GetMapping("/customer/{id}")
    public  Customer  getCustomerById(@PathVariable int id )
    {
     return service.getCustomerUsingId(id);
    }
	
}
