package com.example.model;

public class PatientLogin {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	private String loginUserName;
	private String loginPassword;
	public String getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
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
	public PatientLogin(int id, String loginUserName, String loginPassword) {
		super();
		this.id = id;
		this.loginUserName = loginUserName;
		this.loginPassword = loginPassword;
	}
	public PatientLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
