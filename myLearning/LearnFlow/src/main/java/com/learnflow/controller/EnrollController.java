
package com.learnflow.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import com.learnflow.repository.EnrollmentRepository;


public class EnrollController extends HttpServlet{
	
	private EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("in the Enrollment");
		HttpSession session = request.getSession();
		
		
	    String action = request.getParameter("action");


	
		if(action.equals("enroll")) {
			
			
		    Users user = (Users) session.getAttribute("loggedInUser"); 
		    System.out.println(user.getUsername());
		    
		    int courseId = Integer.parseInt(request.getParameter("actionCourseId"));
			int complitionCourseStatus = 0;
			int last_accessCourse = 0; 
			
						
			Enrollments enrollments = new Enrollments();
			Courses coures = new Courses();
			Users student = new Users();
			
			coures.setCourse_id(courseId);
			student.setUser_id(user.getUser_id());
			Date currentDate = new Date();
			
		    System.out.println("Course--Id: "+coures);
			enrollments.setCourse_id(coures);
			enrollments.setUser_id(student);
			enrollments.setEnrollment_date(currentDate);
			enrollments.setCompletion_status(complitionCourseStatus);
			enrollments.setLast_accessed_lecture_id(last_accessCourse);
			
			System.out.println("enrolling to the course");
			EnrollmentRepository enrollController = new EnrollmentRepository();

			try {
				if (!enrollController.isUserAlreadyEnrolled(user.getUser_id(), courseId)) {
				    
					System.out.println("in the enrolling ");
					boolean checkEnroll = enrollToCourse(enrollments);
					if(checkEnroll) {
						System.out.println("Enrolled......");
						  response.sendRedirect("dashboard.jsp");
					}
					else {
						System.out.println("error while enrolling!!");
					}
				} else {
					System.out.println("in the else");
				    request.setAttribute("message", "You are already enrolled in this course.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			
		}
		
		Object loadAttr = request.getAttribute("loadStudentCourse");

		if (loadAttr != null && loadAttr instanceof Integer) {
		    int studentId = (int) loadAttr;
		    System.out.println("loadingStudentCourse");
		    System.out.println("user id: " + studentId);

		    List<Enrollments> studentCourses = studentEnrollCourses(studentId);
		    
		    session.setAttribute("enrollmentsList", studentCourses);
		    response.sendRedirect("dashboard.jsp");
		}

	}
	
	public boolean enrollToCourse(Enrollments enroll) {
		return enrollmentRepository.enrollToCourse(enroll);
	}
	
	public List<Enrollments> studentEnrollCourses(int id){
		return enrollmentRepository.getEnrollmentsByStudent(id);
	}
}
