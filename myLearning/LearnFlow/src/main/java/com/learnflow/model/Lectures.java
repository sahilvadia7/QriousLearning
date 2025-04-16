package com.learnflow.model;

import com.learnflow.enums.Type;

public class Lectures {
	
	
	private int lecture_id;
	private Courses course_id;
	private String title;
	private double duration;
	private Type type;
	
	public Lectures() {}
	
	public Lectures(int lecture_id, Courses course_id, String title, double duration,Type type) {
		super();
		this.lecture_id = lecture_id;
		this.course_id = course_id;
		this.title = title;
		this.duration = duration;
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getLecture_id() {
		return lecture_id;
	}

	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}

	public Courses getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Courses course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
	
	
}
