package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repository.ProductInventoryRepository;



@Service
public class ProductInventoryServiceImpl implements ProductInventoryService {
	
 @Autowired	
  ProductInventoryRepository productRepository;
	

	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}


	@Override
	public List<Product> getAllProducts() {
		List<Product> prod = productRepository.findAll();
		return prod;
	}


	@Override
	public List<Product> updateProducts(List<Product> product) {	
		Product p = new Product();
		for(Product prod : product) {	
			productRepository.findById(prod.getProd_id());
			p.setProd_id(prod.getProd_id());
			p.setProd_name(prod.getProd_name());
			p.setProd_price(prod.getProd_price());
			p.setProd_qty(prod.getProd_qty());
			productRepository.save(p);
		}
		
		return productRepository.findAll();
	}


	@Override
	public List<Product> getLowQtyProduct() {
		List<Product> lowstock = productRepository.getLowStockProduct();
		return lowstock;
	}

	

}






















/*
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
	}*/
