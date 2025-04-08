package com.fisrtservlet.auth;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fisrtservlet.model.User;

public class RegisterServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");		
		
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setEmail(email);
		user.setGender(gender);
		user.setPassword(password);
		
		session.setAttribute("regUser", user);
		
		response.sendRedirect("Login.html");

	}
}
