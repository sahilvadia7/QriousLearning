package com.learnflow.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.learnflow.model.Courses;
import com.learnflow.model.Users;

public class ActionRepository {
	
	 	private static final String URL = "jdbc:postgresql://localhost:5433/learnflow";
	    private static final String USER = "postgres";
	    private static final String PASS = "root";
	    

	    public boolean enrollToCourseRepo(Courses courses, Users user) {
	        boolean enrolled = false;

	        String USER_ENROLLMENT_COURSE = 
	            "INSERT INTO enrollments (user_id, course_id, enrollment_date, completion_status, last_accessed_lecture_id) " +
	            "VALUES (?, ?, CURRENT_TIMESTAMP, 0.0, NULL)";

	        try {
	            Class.forName("org.postgresql.Driver");
	            Connection connection = DriverManager.getConnection(URL, USER, PASS);
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(USER_ENROLLMENT_COURSE);
	            preparedStatement.setInt(1, user.getUser_id());
	            preparedStatement.setInt(2, courses.getCourse_id());

	            int rows = preparedStatement.executeUpdate(); 

	            if (rows > 0) {
	                enrolled = true;
	            }

	            preparedStatement.close();
	            connection.close();
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }

	        return enrolled;
	    }


}
