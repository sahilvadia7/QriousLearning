package com.learnflow.model;

public class Reviews {

	private int review_id;
	private Users user_id;
	private Courses course_id;
	private int rating;
	private String comment;
	private String created_at;
	
	public Reviews() {
		
	}
	public Reviews(int review_id, Users user_id, Courses course_id, int rating, String comment, String created_at) {
		super();
		this.review_id = review_id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.rating = rating;
		this.comment = comment;
		this.created_at = created_at;
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public Users getUser_id() {
		return user_id;
	}
	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}
	public Courses getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Courses course_id) {
		this.course_id = course_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	
	
}
