package com.example.model;

public class Login {

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
		return "Login [loginUserName=" + loginUserName + ", loginPassword=" + loginPassword + "]";
	}
	public Login(String loginUserName, String loginPassword) {
		super();
		this.loginUserName = loginUserName;
		this.loginPassword = loginPassword;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
