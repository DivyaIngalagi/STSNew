package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Product;



public interface ProductInventoryService {
	Product createProduct(Product product);
	List<Product> getAllProducts();
    List<Product> getLowQtyProduct();
	List<Product> updateProducts(List<Product> product);
}













//List<Product> fetchAllProducts();
//Optional<Product> getSingleProduct(Long id);
//void updatePrice(double price , Long id);