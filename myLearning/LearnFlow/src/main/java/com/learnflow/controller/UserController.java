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

import com.learnflow.enums.Role;
import com.learnflow.model.Categories;
import com.learnflow.model.Courses;
import com.learnflow.model.Enrollments;
import com.learnflow.model.Users;
import com.learnflow.repository.EnrollmentRepository;
import com.learnflow.service.UserService;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 543497619863431334L;
	private UserService userservice = new UserService();
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		     
        String path = request.getServletPath();
		HttpSession session = request.getSession();


		if (request.getParameter("firstname") != null) {

		    String firstname = request.getParameter("firstname").trim();
		    String lastname = request.getParameter("lastname").trim();
		    String username = request.getParameter("username").trim();
		    String email = request.getParameter("email").trim();
		    String password = request.getParameter("password").trim();
		    String bio = request.getParameter("bio").trim();
		    Role role = Role.STUDENT;
		    Date currentDate = new Date();

		    boolean hasError = false;

		    String namePattern = "^[A-Za-z]{4,}$";
		    String usernamePattern = "^[A-Za-z0-9_]{4,}$";
		    String emailPattern = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
		    String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";

		    if (firstname.isEmpty()) {
		        request.setAttribute("firstnameError", "First name cannot be blank.");
		        hasError = true;
		    } else if (!firstname.matches(namePattern)) {
		        request.setAttribute("firstnameError", "First name must have only letters and at least 4 characters.");
		        hasError = true;
		    }

		    if (lastname.isEmpty()) {
		        request.setAttribute("lastnameError", "Last name cannot be blank.");
		        hasError = true;
		    } else if (!lastname.matches(namePattern)) {
		        request.setAttribute("lastnameError", "Last name must have only letters and at least 4 characters.");
		        hasError = true;
		    }

		    if (username.isEmpty()) {
		        request.setAttribute("usernameError", "Username cannot be blank.");
		        hasError = true;
		    } else if (!username.matches(usernamePattern)) {
		        request.setAttribute("usernameError", "Username must be at least 4 characters and contain only letters, digits, or underscores.");
		        hasError = true;
		    }

		    if (email.isEmpty()) {
		        request.setAttribute("emailError", "Email cannot be blank.");
		        hasError = true;
		    } else if (!email.matches(emailPattern)) {
		        request.setAttribute("emailError", "Enter a valid email address.");
		        hasError = true;
		    }

		    if (password.isEmpty()) {
		        request.setAttribute("passwordError", "Password cannot be blank.");
		        hasError = true;
		    } else if (!password.matches(passwordPattern)) {
		        request.setAttribute("passwordError", "Password must be 8+ characters with upper, lower, digit, and special character.");
		        hasError = true;
		    }

		    if (bio.length() > 250) {
		        request.setAttribute("bioError", "Bio cannot exceed 250 characters.");
		        hasError = true;
		    }

			request.setAttribute("firstname", firstname);
		    request.setAttribute("lastname", lastname);
		    request.setAttribute("username", username);
		    request.setAttribute("email", email);
		    request.setAttribute("password", password);
		    request.setAttribute("bio", bio);

		    if (hasError) {
		        request.getRequestDispatcher("register.jsp").forward(request, response);
		        return;
		    }

		    Users user = new Users();
		    user.setfirstname(firstname);
		    user.setlastname(lastname);
		    user.setUsername(username);
		    user.setEmail(email);
		    user.setPassword(password);
		    user.setBio(bio);
		    user.setRegistration_date(currentDate);
		    user.setRole(role);


			try {
				Users registredUser = registerUser(user);
				if (registredUser != null && registredUser.getUsername() != null) {
					response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("error", "Registration failed.");
				}
			} catch (Exception e) {
				request.setAttribute("errorMessage", "Database error during registration.");
				e.printStackTrace();
			}
		} else if (request.getParameter("loginEmail") != null && request.getParameter("loginPassword") != null) {
			String loginEmail = request.getParameter("loginEmail");
			String loginPassword = request.getParameter("loginPassword");

			
			Users user = new Users();
			user.setEmail(loginEmail);
			user.setPassword(loginPassword);

			try {
				Users loggedInUser = loginUser(user);
				if (loggedInUser != null && loggedInUser.getEmail() != null) {
					
					CourseController cc = new CourseController();
					CategoryController categoryController = new CategoryController();
					
					List<Courses> getAllCourse = cc.getAllCourse(); 
				 	List<Users> allUsers = getAllUser();
				 	List<Categories> allCategories = categoryController.getAllCategories();
					
					session.setAttribute("loggedInUser", loggedInUser);
					System.out.println("session while login : "+loggedInUser);
					session.setAttribute("allUsers", allUsers);
					session.setAttribute("allCourse", getAllCourse);
					session.setAttribute("allCategories", allCategories);
				 	
					Role loginUserRole = null;
					int userId = -1;
					for(Users findUserRole: allUsers ) {
						if(loggedInUser.getEmail().equalsIgnoreCase(findUserRole.getEmail())) {
							loginUserRole = findUserRole.getRole();
							userId = findUserRole.getUser_id();
							
							System.out.println("loginUser role : "+loginUserRole);
							request.setAttribute("loadStudentCourse", userId);
					    	request.getRequestDispatcher("requestToUserAction").forward(request, response);
					    	return;
						}
					}
				 	
					response.sendRedirect("dashboard.jsp");
				} else {
					request.setAttribute("loginError", "Invalid email or password.");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				request.setAttribute("loginErrorMessage", "Database error during login.");
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp").forward(request, response);
			} catch (ServletException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			}
		}else if(path.equals("/deleteUser")) {
			Integer DuserId = Integer.parseInt(request.getParameter("DuserId"));
			boolean isDeleted = userservice.deleteUserById(DuserId,session);
			if(isDeleted) {
			    System.out.println("User deleted successfully!");
			    response.sendRedirect("dashboard.jsp");
			    return;

			}else {
			    System.out.println("User not found or could not be deleted.");
			    response.sendRedirect("dashboard.jsp");
			    return;
			}
		}
		
		else {
			request.setAttribute("error", "Invalid request.");
			System.out.println("in else");
		}
		 
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();

		if (path.equals("/logout")) {
			HttpSession session = request.getSession(false); 
															
			if (session != null) {
				session.invalidate();
			}
			response.sendRedirect("login.jsp");
			return;
		} 
		
		
		
	}

	public Users registerUser(Users user) throws SQLException {
		if (user != null) {
			return userservice.registerUser(user);
		}
		return null;
	}

	public Users loginUser(Users user) throws SQLException {
		if (user != null) {
			
			return userservice.loginUser(user);
		}
		return null;
	}
	
	public List<Users> getAllUser(){

		return userservice.getAllUserS();
	}
}
