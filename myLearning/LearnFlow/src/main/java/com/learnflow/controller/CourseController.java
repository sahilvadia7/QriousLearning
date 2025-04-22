package com.learnflow.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnflow.model.Categories;
import com.learnflow.model.Courses;
import com.learnflow.model.Users;
import com.learnflow.service.CourseService;

public class CourseController extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String path = request.getServletPath();
	    System.out.println("path info : " + path);

	    HttpSession session = request.getSession();
	    Users instructor = (Users) session.getAttribute("loggedInUser");

	    if (session == null || instructor == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }

	    if (request.getParameter("title") != null) {
	        String title = request.getParameter("title").trim();
	        String description = request.getParameter("description").trim();
	        String categoryIdStr = request.getParameter("category_id").trim();
	        String priceStr = request.getParameter("price").trim();
	        String discountedStr = request.getParameter("discounted_price").trim();
	        String durationStr = request.getParameter("duration").trim();
	        String languageParam = request.getParameter("language").trim();

	        List<String> errors = new ArrayList<>();

	        if (title == null || title.isEmpty()) errors.add("Title is required.");
	        if (description == null || description.isEmpty()) errors.add("Description is required.");
	        if (categoryIdStr == null || categoryIdStr.isEmpty()) errors.add("Category is required.");
	        if (priceStr == null || priceStr.isEmpty()) errors.add("Price is required.");
	        if (discountedStr == null || discountedStr.isEmpty()) errors.add("Discounted price is required.");
	        if (durationStr == null || durationStr.isEmpty()) errors.add("Duration is required.");

	        int category_Id = 0;
	        double price = 0;
	        double discounted_price = 0;
	        double duration = 0;

	        try {
	            category_Id = Integer.parseInt(categoryIdStr);
	        } catch (NumberFormatException e) {
	            errors.add("Invalid category.");
	        }

	        try {
	            price = Double.parseDouble(priceStr);
	            if (price < 0) errors.add("Price cannot be negative.");
	        } catch (NumberFormatException e) {
	            errors.add("Invalid price.");
	        }

	        try {
	            discounted_price = Double.parseDouble(discountedStr);
	            if (discounted_price < 0) errors.add("Discounted price cannot be negative.");
	        } catch (NumberFormatException e) {
	            errors.add("Invalid discounted price.");
	        }

	        try {
	            duration = Double.parseDouble(durationStr);
	            if (duration <= 0) errors.add("Duration must be positive.");
	        } catch (NumberFormatException e) {
	            errors.add("Invalid duration.");
	        }

	        if (!errors.isEmpty()) {
	            request.setAttribute("errors", errors);
	            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	            return;
	        }

	        List<String> languages = new ArrayList<>();
	        if (languageParam != null && !languageParam.trim().isEmpty()) {
	            languages = Arrays.asList(languageParam.split(","));
	        } else {
	            languages = Collections.singletonList("N/A");
	        }

	        Categories category = new Categories();
	        category.setCategory_id(category_Id);

	        Courses course = new Courses();
	        course.setTitle(title);
	        course.setDescription(description);
	        course.setInstructor_id(instructor);
	        course.setCategory_id(category);
	        course.setPrice((int) price);
	        course.setDiscounted_price((int) discounted_price);
	        course.setDuration(duration);
	        course.setLanguage(languages);
	        Date now = new Date();
	        course.setCreated_at(now);
	        course.setUpdated_at(now);

	        boolean isSaved = addNewCourses(course);

	        if (isSaved) {
	            List<Courses> updatedCourses = courseService.getCoursesByInstructor(instructor.getUser_id());
	            session.setAttribute("instructorCourses", updatedCourses);
	            request.setAttribute("addedCourse", course);
		        request.getRequestDispatcher("success.jsp").forward(request, response);

	        } else {
	            request.setAttribute("error", "Failed to create course.");
	        }

	        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	    }

	    if (path.equalsIgnoreCase("/fetchInstructorCourse")) {
	        List<Courses> getAllInstructorCourse = courseService.getCoursesByInstructor(instructor.getUser_id());
	        session.setAttribute("instructorCourses", getAllInstructorCourse);
	        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	    }
	}


	
	private CourseService courseService = new CourseService();
	
	public List<Courses> getAllCourse(){
		return courseService.getAllCourse(); 
	}
	
	public boolean addNewCourses(Courses course) {
		return courseService.addCourse(course);
	}
	
	public List<Courses> getCoursesByInstructor(int id){
		return courseService.getCoursesByInstructor(id);
	}
}