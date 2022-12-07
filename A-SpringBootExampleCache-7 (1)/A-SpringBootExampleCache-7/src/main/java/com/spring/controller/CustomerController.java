package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.echace.CacheCustomer;
import com.spring.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	CacheCustomer cacheCustomer;
	
	
	
    @GetMapping("/customer/{name}")
    public  Customer  getCustomerById(@PathVariable String custName )
    {
     return cacheCustomer.getCustomerByName(custName);
    }
	
}
