package com.learnflow.model;

public class Categories {

	private int category_id;
	private String name;
	private String description;
	
	public Categories() {
		
	}

	public Categories(int category_id, String name, String description) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.description = description;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
