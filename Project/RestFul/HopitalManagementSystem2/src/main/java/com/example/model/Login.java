package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminlogin")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String loginUserName;
	private String loginPassword;
	public String getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", loginUserName=" + loginUserName + ", loginPassword=" + loginPassword + "]";
	}
	public Login(int id, String loginUserName, String loginPassword) {
		super();
		this.id = id;
		this.loginUserName = loginUserName;
		this.loginPassword = loginPassword;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
