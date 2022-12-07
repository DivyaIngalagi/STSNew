package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private double productPrice;
	private String productName;
	private int quantity;
	public Product(long productId, double productPrice, String productName, int quantity) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
		this.productName = productName;
		this.quantity = quantity;
	}
	public Product() {
		super();
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productPrice=" + productPrice + ", productName=" + productName
				+ ", quantity=" + quantity + "]";
	}
	
}
