package com.example.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.model.Employee;

public class EmployeeDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Collection<Employee> getAllEmployee() {
		
		return entityManager.createQuery("from Employee",Employee.class).getResultList();
	}
}
