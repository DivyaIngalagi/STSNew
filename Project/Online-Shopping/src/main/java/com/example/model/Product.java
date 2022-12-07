package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int prod_id;
	String prod_name;
	int prod_qty;
	double prod_price;
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(int prod_qty) {
		this.prod_qty = prod_qty;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public Product(int prod_id, String prod_name, int prod_qty, double prod_price) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_qty = prod_qty;
		this.prod_price = prod_price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
