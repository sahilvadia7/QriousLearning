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
import com.learnflow.model.Users;
import com.learnflow.service.UserService;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 543497619863431334L;
	private UserService userservice = new UserService();
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



			 List<Users> users = getAllUser();
		     request.setAttribute("allUsers", users);
		     
		     
		 if (request.getParameter("firstname") != null) {
			String first_name = request.getParameter("firstname");
			String last_name = request.getParameter("lastname");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String bio = request.getParameter("bio");
			Role role = Role.STUDENT;
			Date currentDate = new Date();

			Users user = new Users();
			user.setfirstname(first_name);
			user.setlastname(last_name);
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
					

				 	List<Users> allUsers = getAllUser(); 
					HttpSession session = request.getSession();
					session.setAttribute("loggedInUser", loggedInUser);
					session.setAttribute("allUsers", allUsers);

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
		} else {
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
