package com.learnflow.model;

import java.sql.Date;

public class Enrollments {

	private int enrollment_id;
	private Users user_id;
	private Courses course_id;
	private Date enrollment_date;
	private double completion_status;
	private int last_accessed_lecture_id;
	
	
	public Enrollments() {}
	public Enrollments(int enrollment_id, Users user_id, Courses course_id, Date enrollment_date,
			double completion_status, int last_accessed_lecture_id) {
		super();
		this.enrollment_id = enrollment_id;
		this.user_id = user_id;
		this.course_id = course_id;
		this.enrollment_date = enrollment_date;
		this.completion_status = completion_status;
		this.last_accessed_lecture_id = last_accessed_lecture_id;
	}
	public int getEnrollment_id() {
		return enrollment_id;
	}
	public void setEnrollment_id(int enrollment_id) {
		this.enrollment_id = enrollment_id;
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
	public Date getEnrollment_date() {
		return enrollment_date;
	}
	public void setEnrollment_date(Date enrollment_date) {
		this.enrollment_date = enrollment_date;
	}
	public double getCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(double completion_status) {
		this.completion_status = completion_status;
	}
	public int getLast_accessed_lecture_id() {
		return last_accessed_lecture_id;
	}
	public void setLast_accessed_lecture_id(int last_accessed_lecture_id) {
		this.last_accessed_lecture_id = last_accessed_lecture_id;
	}
	
	
	
	
}
