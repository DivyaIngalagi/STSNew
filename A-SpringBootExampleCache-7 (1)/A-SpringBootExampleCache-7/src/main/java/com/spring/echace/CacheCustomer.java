package com.spring.echace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;

@Component
public class CacheCustomer {

	@Autowired
	CustomerRepository repository;
	
	
	@Cacheable(value="customerCache",key="#name")
	public Customer getCustomerByName(String name) {
		return repository.findByCustName(name);
	}
	
}
