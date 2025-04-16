package com.learnflow.model;

import java.util.Date;

import com.learnflow.enums.Role;

public class Users {
	
	private int user_id;
	private String username;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private Date registration_date;
	private String bio;
	private Role role;
	
	
	
	public Users() {
		super();
	}
	
	
	public Users(int user_id, String username, String email, String password, String firstname, String lastname,
			Date registration_date, String bio,Role role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.registration_date = registration_date;
		this.bio = bio;
		this.role =role;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	  public Role getRole() {
	        return role;
	    }
	    
	    public void setRole(Role role) {
	        this.role = role;
	    }
	    

}
