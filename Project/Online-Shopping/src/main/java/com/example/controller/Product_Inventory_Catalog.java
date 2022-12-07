package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/inventory")
public class Product_Inventory_Catalog {

	@Autowired
	ProductService productserv;
	
	@PostMapping("/product")
	public ResponseEntity saveProduct(@RequestBody Product product) {
	
		Product prod = productserv.createProduct(product);
		return ResponseEntity.ok("Product saved successfully:"+prod);
	}
	
}
