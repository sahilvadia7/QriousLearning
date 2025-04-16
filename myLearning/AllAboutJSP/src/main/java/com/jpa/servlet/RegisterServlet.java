package com.jpa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jpa.model.Users;
import com.jpa.model.Users.ROLE;
import com.jpa.dao.UserDao;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = -1207137735962826328L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		ROLE role = ROLE.USER;

		Users user = new Users(name, email, password, role);
		UserDao dao = new UserDao();

		try {
			boolean isPresent = dao.login(user) != null;

			if (!isPresent) {
				boolean isSaved = dao.saveUser(user);

				if (isSaved) {
					session.setAttribute("user", user);
					response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("error", "Registration failed.");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("error", "already Register");
				response.sendRedirect("index.jsp");

			}
		} catch (SQLException e) {
			throw new ServletException("DB Error", e);
		}
	}
}
