package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Payment;
import com.example.service.PaymentService;




@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment)
	{
		
		return paymentService.doPayment(payment);
	}

}

