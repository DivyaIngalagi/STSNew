package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductCatalogService;


import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/catalog")
public class Product_Catalog_Controller {

	@Autowired
	ProductCatalogService productserv;
	
	
	@GetMapping("/getproduct")
	public ResponseEntity getAllProduct() {
		List<Product> allprod = productserv.getAllProducts();
		return ResponseEntity.ok(allprod);
	}
	
	
}
