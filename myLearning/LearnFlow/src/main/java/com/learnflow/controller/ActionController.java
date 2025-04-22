package com.learnflow.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnflow.model.Courses;
import com.learnflow.model.Enrollments;
import com.learnflow.model.Users;
import com.learnflow.model.Wishlists;
import com.learnflow.repository.CourseRepository;
import com.learnflow.repository.EnrollmentRepository;

public class ActionController extends HttpServlet{
	
	private static final long serialVersionUID = -4263683605282744515L;
	private EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    System.out.println("in the Enrollment");
	    HttpSession session = request.getSession();

	    String action = request.getParameter("action");
	    System.out.println(action);

	    if ("enroll".equals(action)) {
	        Users user = (Users) session.getAttribute("loggedInUser");

	        int courseId = Integer.parseInt(request.getParameter("actionCourseId"));
	        int complitionCourseStatus = 0;
	        int last_accessCourse = 0;

	        Enrollments enrollments = new Enrollments();
	        Courses course = new Courses();
	        Users student = new Users();

	        course.setCourse_id(courseId);
	        student.setUser_id(user.getUser_id());
	        Date currentDate = new Date();

	        enrollments.setCourse_id(course);
	        enrollments.setUser_id(student);
	        enrollments.setEnrollment_date(currentDate);
	        enrollments.setCompletion_status(complitionCourseStatus);
	        enrollments.setLast_accessed_lecture_id(last_accessCourse);

	        System.out.println("enrolling to the course");
	        
	        
	        EnrollmentRepository enrollRepo = new EnrollmentRepository();
	        boolean isAlredyEnroll = false;
			try {
				isAlredyEnroll = enrollRepo.isUserAlreadyEnrolled(user.getUser_id(), courseId);
				System.out.println("is alredy enroll : "+ isAlredyEnroll);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (!isAlredyEnroll) {
				    
					  boolean checkEnroll = enrollmentRepository.enrollToCourse(enrollments);

				        if (checkEnroll) {
				            List<Enrollments> studentCourses = enrollmentRepository.getEnrollmentsByStudent(user.getUser_id());
				            session.setAttribute("enrollmentsList", studentCourses);

				            try {
				                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				                return;
				            } catch (ServletException e) {
				                e.printStackTrace();
				            }
				        } else {
				            System.out.println("error while enrolling!!");
				            response.sendRedirect("error.jsp"); 
				        }
				} else {
				    request.setAttribute("message", "You are already enrolled in this course.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	        
	        
	        
	    }
	    else if("wishlist".equals(action)) {
	    	
	        Users user = (Users) session.getAttribute("loggedInUser");

	    	 int courseId = Integer.parseInt(request.getParameter("actionCourseId"));

		        Wishlists wishlists = new Wishlists();
		        Courses course = new Courses();
		        Users student = new Users();

		        course.setCourse_id(courseId);
		        student.setUser_id(user.getUser_id());

		        wishlists.setCourse_id(course);
		        wishlists.setUser_id(student);

		        System.out.println("adding to wishlist");
		        boolean checkwishlist = enrollmentRepository.addtoWishList(wishlists);

		        if (checkwishlist) {
		            List<Wishlists> wishlistCourses = enrollmentRepository.getWishlistByStudent(user.getUser_id());
		            session.setAttribute("wishlistList", wishlistCourses);

		            try {
		                request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		                return;
		            } catch (ServletException e) {
		                e.printStackTrace();
		            }
		        }
		        	else {
		            System.out.println("error while wishlisting!!");
		            response.sendRedirect("error.jsp"); 
		        }
	    }
	    
	    else if ("courseDetails".equals(action)) {
	        int courseId = Integer.parseInt(request.getParameter("actionCourseId"));
	        CourseRepository courseRepository = new CourseRepository();
	        
	        Courses courseInDetail = courseRepository.getCourseById(courseId);
	        System.out.println("detail about course"+courseInDetail.getTitle());
	        request.setAttribute("courseDetails", courseInDetail);
	        
	        try {
	            request.getRequestDispatcher("success.jsp").forward(request, response);
	        } catch (ServletException | IOException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    Object loadAttr = request.getAttribute("loadStudentCourse");
	    if (loadAttr != null && loadAttr instanceof Integer) {
	        int studentId = (int) loadAttr;
	        System.out.println("loadingStudentCourse | user id: " + studentId);

	        List<Enrollments> studentCourses = enrollmentRepository.getEnrollmentsByStudent(studentId);
	        session.setAttribute("enrollmentsList", studentCourses);

	        List<Wishlists> wishlistCourses = enrollmentRepository.getWishlistByStudent(studentId);
	        session.setAttribute("wishlistList", wishlistCourses);

	        try {
	            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	        } catch (ServletException | IOException e) {
	            e.printStackTrace();
	        }
	    }

	}
}