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
import com.example.service.ProductInventoryService;


import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/inventory")
public class Product_Inventory_Controller {

	@Autowired
	ProductInventoryService productserv;
	
	@PostMapping("/addproduct")
	public ResponseEntity saveProduct(@RequestBody Product product) {
	
		Product prod = productserv.createProduct(product);
		return ResponseEntity.ok("Product saved successfully:"+prod);
	}
	
	@GetMapping("/getproduct")
	public List<Product> getAllProduct() {
		List<Product> allprod = productserv.getAllProducts();
		return allprod;
	}
	
	@GetMapping("/getLowStockProduct")
	public ResponseEntity getLowStockProduct()
	{
		List<Product> lowstockprod = productserv.getLowQtyProduct();
	
		 return ResponseEntity.ok("Less than 10 qty products are:"+lowstockprod);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity updateProducts(@RequestBody List<Product> product) {
		
		List<Product> updateprod = productserv.updateProducts(product);
		
		return ResponseEntity.ok("Updated Products are:"+updateprod);
	}
}
