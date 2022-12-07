package com.spring.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Payment;
import com.spring.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;
	

	public Payment doPayment(Payment payment)
	{
		//call to the payment gateway
		payment.setPaymentStatus(paymentProcess());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}
	
	public String paymentProcess()
	{
		// giving call to the paymeny gateway(Paypal,paytm..)
		return new Random().nextBoolean()?"success":"false";
	}
}
