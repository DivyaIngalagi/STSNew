package com.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.ProductNotFoundException;
import com.spring.model.Product;
import com.spring.model.UpdateProduct;
import com.spring.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity creatNewProduct(@RequestBody Product product)
	{
		Product prod=productService.createProduct(product);
		return ResponseEntity.ok("Product has added to DB" +prod);
	}
	
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> fetchSingleProduct(@PathVariable Long id)
	{
		Optional<Product> prod=productService.getSingleProduct(id);
		if(prod.isPresent())
		 return ResponseEntity.ok(prod.get());
		throw new ProductNotFoundException(id);
	}
	
	
	@PutMapping("/product/{id}")
	public ResponseEntity updateProductPrice(@PathVariable Long id,@RequestBody UpdateProduct updateProduct)
	{
		productService.updatePrice(updateProduct.getProductPrice(), id);
		return ResponseEntity.ok(productService.getSingleProduct(id).get());
	}
	
}
