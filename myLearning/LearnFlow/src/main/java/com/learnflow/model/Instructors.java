package com.learnflow.model;

import java.util.List;

public class Instructors {
	
	private Users instructor_id;
	private String biography;
	private List<String> skills;
	private String social_media_links;
	
	
	
	public Instructors() {
		super();
	}
	
	public Instructors(Users instructor_id, String biography, List<String> skills, String social_media_links) {
		super();
		this.instructor_id = instructor_id;
		this.biography = biography;
		this.skills = skills;
		this.social_media_links = social_media_links;
	}
	public Users getInstructor_id() {
		return instructor_id;
	}
	public void setInstructor_id(Users instructor_id) {
		this.instructor_id = instructor_id;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getSocial_media_links() {
		return social_media_links;
	}
	public void setSocial_media_links(String social_media_links) {
		this.social_media_links = social_media_links;
	}
	
	
	
}
