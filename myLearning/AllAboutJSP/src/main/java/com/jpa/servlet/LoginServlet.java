package com.jpa.servlet;

import com.jpa.dao.UserDao;
import com.jpa.model.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users user = new Users();
        user.setEmail(email);
        user.setPassword(password);

        UserDao userDAO = new UserDao();
        Users loginSuccess = userDAO.login(user);
        System.out.println(loginSuccess);
        HttpSession session = request.getSession();
        
        if (loginSuccess!=null) {
            session.setAttribute("activeUser",loginSuccess);
            response.sendRedirect("home.jsp");
        } else {
            session.setAttribute("error", "Invalid credentials.");
            response.sendRedirect("login.jsp");
        }
    }
}
