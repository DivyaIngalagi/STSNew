package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserNewDetailsTable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	private String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
}
