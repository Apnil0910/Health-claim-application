package com.app.healthclaim.healthapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class User {
	
	@Id
	private String email;
	private String password;
	

	public String getEmail() {
		return email;
	}
	public void setEmailId(String emailId) {
		this.email = emailId;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(int id, String emailId, String password) {
		super();
		this.email = emailId;
		this.password = password;
	}
	public User() {
		
	}

	
}
