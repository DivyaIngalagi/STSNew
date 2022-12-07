package com.training.app.model;

import java.util.List;

public class Physician {

	private int id;
	private String name;
	private String contact;
	private String email;
	private List<String> specialities;

	public Physician() {
		super();
	}

	public Physician(int id, String name, String contact, String email, List<String> specialities) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.specialities = specialities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<String> specialities) {
		this.specialities = specialities;
	}

}
