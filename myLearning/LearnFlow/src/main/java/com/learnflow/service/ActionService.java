package com.learnflow.service;

import com.learnflow.model.Courses;
import com.learnflow.model.Users;
import com.learnflow.repository.ActionRepository;

public class ActionService {

	private ActionRepository actionRepository = new ActionRepository();
	
	public boolean enrollToCourseService(Courses courses,Users user) {
		if(courses!=null && user!=null) {
			return actionRepository.enrollToCourseRepo(courses,user);
		}
		System.out.println("someting null");
		return false;
	}
	
}
