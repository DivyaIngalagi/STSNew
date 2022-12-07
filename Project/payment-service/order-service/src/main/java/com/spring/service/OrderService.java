package com.spring.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Order;
import com.spring.model.Payment;
import com.spring.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository paymentRepository;
	

	public Order addOrder(TransactionRequest request)
	{
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//rest call
		
		return paymentRepository.save(order);
	}
}
