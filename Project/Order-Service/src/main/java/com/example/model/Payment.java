package com.example.model;
//DTO Class if we want to save details of a payment inside order class
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class Payment {


   private int id;
   private String paymentStatus;
   private String transactionId;
   
 
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
