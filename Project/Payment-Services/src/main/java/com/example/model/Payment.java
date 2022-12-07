package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name="PaymentDetails")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String paymentStatus;
   private String transactionId;
   
   //now has to fetch order ID and also amount passed by order service2
   private int orderId;
   private double amount;
   
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
   
   
}
