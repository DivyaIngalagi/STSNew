package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Product;
import com.spring.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
 @Autowired	
  ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public List<Product> fetchAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getSingleProduct(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void updatePrice(double price, Long id) {
     productRepository.updateProductPrice(price, id);
	}

}
