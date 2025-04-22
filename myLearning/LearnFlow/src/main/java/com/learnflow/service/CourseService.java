package com.learnflow.service;

import java.util.List;

import com.learnflow.model.Courses;
import com.learnflow.repository.CourseRepository;

public class CourseService {

	private CourseRepository courseRepository = new CourseRepository();
	
	public List<Courses> getAllCourse() {
		return courseRepository.getAllCourses();
	}

	public boolean addCourse(Courses course) {
		return courseRepository.addCourses(course);
	}
	
	public List<Courses> getCoursesByInstructor(int id){
		return courseRepository.getCoursesByInstructor(id);
	}
	
	
}
