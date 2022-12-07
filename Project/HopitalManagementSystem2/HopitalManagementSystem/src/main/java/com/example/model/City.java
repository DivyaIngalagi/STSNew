package com.example.model;

public class City {

	private String city;
	private int cityid;

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCity() {
		return city;
	}

	public City(String city) {
		super();
		this.city = city;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
