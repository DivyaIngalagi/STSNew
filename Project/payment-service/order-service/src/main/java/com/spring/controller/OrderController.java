package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Order;
import com.spring.service.OrderService;
import com.spring.service.TransactionRequest;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@PostMapping("/bookOrder")
	public Order bookOrder(@RequestBody TransactionRequest request)
	{
		// give a call to the payment and pass the order id
		return orderService.addOrder(request);
	}

}
