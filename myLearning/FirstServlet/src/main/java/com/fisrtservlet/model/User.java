package com.fisrtservlet.model;

public class User {
	
	private String email;
	private String gender;
	private String password;
	
	public User() {}
	public User(String email, String gender, String password) {
		super();
		this.email = email;
		this.gender = gender;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", gender=" + gender + ", password=" + password + "]";
	}
	
	

}
