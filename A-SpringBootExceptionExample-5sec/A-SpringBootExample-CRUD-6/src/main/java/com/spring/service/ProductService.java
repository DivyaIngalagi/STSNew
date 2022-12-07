package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.model.Product;

public interface ProductService {
	Product createProduct(Product product);
	List<Product> fetchAllProducts();
	Optional<Product> getSingleProduct(Long id);
	void updatePrice(double price , Long id);
   
}
