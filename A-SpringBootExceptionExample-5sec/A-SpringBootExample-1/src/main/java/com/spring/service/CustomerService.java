package com.spring.service;

import java.util.List;

import com.spring.model.Customer;

public interface CustomerService {
public Customer SaveCustomer(Customer customer);
public List<Customer> getAllCustomer();
}
