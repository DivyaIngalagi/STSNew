package com.example.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Order;
import com.example.model.Payment;
import com.example.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository paymentRepository;
	
	//Rest Template to communication between services we have to creat a bean fo this we can't use it easily
	@Autowired
	RestTemplate restTemplate;
	
//	public Order addOrder(Order order)1st
//	{
//		
//		
//		return paymentRepository.save(order);
//	}
	//store transaction details also
	public TransactionResponse addOrder(TransactionRequest request)
	{
		String message="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//rest call
		Payment paymentResponse = restTemplate.postForObject("http://localhost:8282/payment/doPayment", payment, Payment.class);
		message=paymentResponse.getPaymentStatus().equals("success")?"Payment done successfully your order is placed":"Payment not done your order ia added back to the cart";
		paymentRepository.save(order);
		
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),message);
	}
}
