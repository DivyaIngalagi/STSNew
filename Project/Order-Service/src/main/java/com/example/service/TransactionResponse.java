package com.example.service;

import com.example.model.Order;

public class TransactionResponse {

	private Order order;
	private double amount;
	private String transactionId;
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResponse(Order order, double amount, String transactionId, String mesage) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.mesage = mesage;
	}
	private String mesage;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	
}
