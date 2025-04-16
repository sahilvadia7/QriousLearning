package com.jpa.model;

public class Users {
	
	public enum ROLE{
		ADMIN,
		USER,
		GUEST
	}
	
	private int id;
	private String name;
	private String email;
	private String password;
	private ROLE role;
	
	public Users() {}
	public Users(int id,String name, String email, String password,ROLE role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public Users(String name, String email, String password,ROLE role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
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
	public ROLE getRole() {
		return role;
	}
	public void setRole(ROLE role) {
		this.role = role;
	}

}
