package com.spring.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
		
	@Override
	public Customer SaveCustomer(Customer customer) {
		
		Customer cust=	customerRepository.save(customer);
		return cust;
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		//customerRepository.f
		return null;
	}

	@Override
	public Customer getCustomerUsingId(int id) {
		return	customerRepository.findById(id).get();
		 
	}
	
	

}
