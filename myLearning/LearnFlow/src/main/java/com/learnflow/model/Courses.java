package com.learnflow.model;

import java.util.Date;
import java.util.List;

public class Courses {
	
	private enum Level {
		BEGINNER,
		INTREMEDIATE,
		ADVANCED
	} 

	private int course_id;
	private String title;
	private String description;
	private Users instructor_id;
	private Categories category_id;
	private int price;
	private int discounted_price;
	private double duration;
	private List<String> language;
	private Date created_at;
	private Date updated_at;
	private int studentCount;

	
	
	public Courses() {
		
	}
	
	
	public Courses(int course_id, String title, String description, Users instructor_id, Categories category_id,
			int price, int discounted_price, double duration, List<String> language, Date created_at, Date updated_at, int studentCount) {
		super();
		this.course_id = course_id;
		this.title = title;
		this.description = description;
		this.instructor_id = instructor_id;
		this.category_id = category_id;
		this.price = price;
		this.discounted_price = discounted_price;
		this.duration = duration;
		this.language = language;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.studentCount =studentCount;
	}
	public int getStudentCount() {
		return studentCount;
	}


	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}


	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Users getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(Users instructor_id) {
		this.instructor_id = instructor_id;
	}
	public Categories getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Categories category_id) {
		this.category_id = category_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscounted_price() {
		return discounted_price;
	}
	public void setDiscounted_price(int discounted_price) {
		this.discounted_price = discounted_price;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
}
