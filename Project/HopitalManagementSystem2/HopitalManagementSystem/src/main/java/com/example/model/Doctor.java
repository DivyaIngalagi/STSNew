package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctorhospital")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int docid;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String mobileno;
	private String gender;
	private String city;
	private String specializaton;
	private String qualification;
	private String address;
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSpecializaton() {
		return specializaton;
	}
	public void setSpecializaton(String specializaton) {
		this.specializaton = specializaton;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", mobileno=" + mobileno + ", gender="
				+ gender + ", city=" + city + ", specializaton=" + specializaton + ", qualification=" + qualification
				+ ", address=" + address + "]";
	}
	public Doctor(int docid, String firstName, String lastName, String username, String password, String email,
			String mobileno, String gender, String city, String specializaton, String qualification, String address) {
		super();
		this.docid = docid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileno = mobileno;
		this.gender = gender;
		this.city = city;
		this.specializaton = specializaton;
		this.qualification = qualification;
		this.address = address;
	}
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
