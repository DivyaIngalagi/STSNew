package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.service.OrderService;
import com.example.service.TransactionRequest;
import com.example.service.TransactionResponse;



@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
//	@PostMapping("/bookOrder")
//	public Order bookOrder(@RequestBody Order order)
//	{
//		
//		return orderService.addOrder(order);
//	}	
		//Now it has to give a call to the payment service and pass the order id
		@PostMapping("/bookOrder")
		public TransactionResponse bookOrder(@RequestBody TransactionRequest request)
		{
			
			return orderService.addOrder(request);
			
	}

}

