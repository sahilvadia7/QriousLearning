package com.fisrtservlet.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fisrtservlet.model.User;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("regUser");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		 if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
			 response.sendRedirect("home.html?email=" + URLEncoder.encode(email, "UTF-8"));
	        } else {
	            response.getWriter().println("Invalid credentials. <a href='login.html'>Try again</a>");
	        }
		
	}

}
