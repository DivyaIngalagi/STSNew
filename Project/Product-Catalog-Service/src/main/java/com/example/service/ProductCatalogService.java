package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Product;



@Service
public class ProductCatalogService {
	

 @Autowired
 RestTemplate restTemplate;
 

	public List<Product> getAllProducts() {

		ResponseEntity<Product[]> response = restTemplate.getForEntity("http://INVENTORY-SERVICE/inventory/getproduct", Product[].class);
		System.out.println("Catalog Data"+response.getBody());
		Product[] product = response.getBody();
		return Arrays.asList(product);
		
		
//		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGETList, Object[].class);
//		Object[] objects = responseEntity.getBody();
		
	}

	/*
	 * ResponseEntity<Employee[]> response = restTemplate.getForEntity(
	 * "http://localhost:8080/employees/", Employee[].class)
	 */
}





















//List<Product> prod = productRepository.findAll();
//return prod;

//ResponseEntity<Product[]> response = restTemplate.getForEntity("http://localhost:9001/inventory/getproduct", Product[].class);
//Product[] product = response.getBody();
//return Arrays.asList(product);
