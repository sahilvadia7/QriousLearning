package com.learnflow.model;

import java.util.Date;

public class Wishlists {
	private int wishlist_item_id;
	private Users user_id;
	private Courses course_id;
	private Date added_date;
	
	public Wishlists() {}
	public Wishlists(int wishlist_item_id, Users user_id, Courses course_id, Date added_date) {
		super();
		this.wishlist_item_id = wishlist_item_id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.added_date = added_date;
	}
	public int getWishlist_item_id() {
		return wishlist_item_id;
	}
	public void setWishlist_item_id(int wishlist_item_id) {
		this.wishlist_item_id = wishlist_item_id;
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
	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}
	
	
	
	
}
