package com.learnflow.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.learnflow.model.Categories;
import com.learnflow.model.Courses;
import com.learnflow.model.Enrollments;
import com.learnflow.model.Users;
import com.learnflow.model.Wishlists;

public class EnrollmentRepository { 

	 	private static final String URL = "jdbc:postgresql://localhost:5433/learnflow";
	    private static final String USER = "postgres";
	    private static final String PASS = "root";
	    
	    
	    public boolean enrollToCourse(Enrollments enroll) {
	        boolean rowsAffected = false;
	        

	        String ENROLL_TO_COURSE = "INSERT INTO enrollments (user_id, course_id, enrollment_date, completion_status, last_accessed_lecture_id) "
	                   + "VALUES (?, ?, CURRENT_DATE, ?, ?)";
	        
	        try {
	            Class.forName("org.postgresql.Driver");
	            Connection connection = DriverManager.getConnection(URL, USER, PASS);
	          	              
	            PreparedStatement preparedStatement = connection.prepareStatement(ENROLL_TO_COURSE);
	            preparedStatement.setInt(1, enroll.getUser_id().getUser_id());
	            preparedStatement.setInt(2, enroll.getCourse_id().getCourse_id());
	            preparedStatement.setDouble(3, enroll.getCompletion_status()); 
	            preparedStatement.setInt(4, enroll.getLast_accessed_lecture_id()); 
	            
	            rowsAffected = preparedStatement.executeUpdate() > 0;

	        }catch (Exception e) {
	        	e.printStackTrace();
			}

	        return rowsAffected;

	    }
	    
	    
	    

	    public boolean addtoWishList(Wishlists wishlists) {
	        boolean rowsAffected = false;

	        String sql = "INSERT INTO wishlists (user_id, course_id, added_date) "
	                   + "VALUES (?, ?, CURRENT_DATE)";
	        
	        try { 
	        	Class.forName("org.postgresql.Driver");
	            Connection connection = DriverManager.getConnection(URL, USER, PASS);
	          	              
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, wishlists.getUser_id().getUser_id());
	            preparedStatement.setInt(2, wishlists.getCourse_id().getCourse_id());
	            rowsAffected = preparedStatement.executeUpdate() > 0;

	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	           
	        return rowsAffected;
	    }
	    
	    
	    public List<Enrollments> getEnrollmentsByStudent(int userId) {
	        List<Enrollments> enrollmentList = new ArrayList<>();
	        
	        String sql = "SELECT e.enrollment_id, e.enrollment_date, e.completion_status, e.last_accessed_lecture_id, " +
	                     "c.course_id, c.title, c.description, c.instructor_id, c.category_id, c.price, c.discounted_price, c.duration, c.language " +
	                     "FROM enrollments e " +
	                     "JOIN courses c ON e.course_id = c.course_id " +
	                     "WHERE e.user_id = ?";
	        
	        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            
	            stmt.setInt(1, userId);
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                Enrollments enrollment = new Enrollments();
	                Courses course = new Courses();
	                Users user = new Users();
	                Categories categories = new Categories();
	                
	                enrollment.setEnrollment_id(rs.getInt("enrollment_id"));
	                enrollment.setEnrollment_date(rs.getDate("enrollment_date"));
	                enrollment.setCompletion_status(rs.getDouble("completion_status"));
	                enrollment.setLast_accessed_lecture_id(rs.getInt("last_accessed_lecture_id"));
	                
	                course.setCourse_id(rs.getInt("course_id"));
	                course.setTitle(rs.getString("title"));
	                course.setDescription(rs.getString("description"));
	                
	                user.setUser_id(rs.getInt("instructor_id"));
	                course.setInstructor_id(user);
	                
	                
	                categories.setCategory_id(rs.getInt("category_id"));
	                course.setCategory_id(categories);
	                
	                
	                course.setPrice((int) rs.getDouble("price"));
	                course.setDiscounted_price((int) rs.getDouble("discounted_price"));
	                course.setDuration(Double.parseDouble(rs.getString("duration")));
	                
	                String langStr = rs.getString("language");
	                List<String> languages = Arrays.asList(langStr.split("\\s*,\\s*"));
	                course.setLanguage(languages);
	                
	                enrollment.setCourse_id(course);
	                
	                user.setUser_id(userId);
	                enrollment.setUser_id(user);
	                
	                enrollmentList.add(enrollment);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return enrollmentList;
	    }



	    public List<Wishlists> getWishlistByStudent(int userId) {
	        List<Wishlists> wishlistList = new ArrayList<>();

	        String sql = "SELECT w.wishlist_item_id, w.added_date, " +
	                     "c.course_id, c.title, c.description, c.instructor_id, c.category_id, c.price, c.discounted_price, c.duration, c.language " +
	                     "FROM wishlists w " +
	                     "JOIN courses c ON w.course_id = c.course_id " +
	                     "WHERE w.user_id = ?";

	        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, userId);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                Wishlists wish = new Wishlists();
	                Courses course = new Courses();
	                Users instructor = new Users();
	                Categories category = new Categories();

	                wish.setWishlist_item_id(rs.getInt("wishlist_item_id"));
	                wish.setAdded_date(rs.getDate("added_date"));

	                course.setCourse_id(rs.getInt("course_id"));
	                course.setTitle(rs.getString("title"));
	                course.setDescription(rs.getString("description"));
	                course.setDuration(Double.parseDouble(rs.getString("duration")));
	                course.setPrice((int) rs.getDouble("price"));
	                course.setDiscounted_price((int) rs.getDouble("discounted_price"));
	                course.setLanguage(Arrays.asList(rs.getString("language").split(",")));

	                instructor.setUser_id(rs.getInt("instructor_id"));
	                course.setInstructor_id(instructor);

	                category.setCategory_id(rs.getInt("category_id"));
	                course.setCategory_id(category);

	                wish.setCourse_id(course);

	                wishlistList.add(wish);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return wishlistList;
	    }

	    public boolean isUserAlreadyEnrolled(int userId, int courseId) throws SQLException {
	    	System.out.println("repo of Check Enrollment");
	        Connection conn = DriverManager.getConnection(URL, USER, PASS);
	        String sql = "SELECT COUNT(*) FROM enrollments WHERE user_id = ? AND course_id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, userId);
	        ps.setInt(2, courseId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	        return false;
	    }

}
