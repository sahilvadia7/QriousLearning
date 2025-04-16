package com.lifecycleofservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpServletResponseMethods extends HttpServlet{

//	✔ Methods Covered:
//		setContentType()
//		getWriter()
//		sendRedirect()
//		setHeader()
//		addCookie()
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException  {
		 res.setContentType("text/html");
	        PrintWriter out = res.getWriter();

	        res.setHeader("Cache-Control", "no-cache");
			String username = req.getParameter("username");

	        HttpSession session = req.getSession();
	        session.setAttribute("username", username);
	        session.setMaxInactiveInterval(30);
	        
	        out.println("Cookie added and redirected...");
	        res.sendRedirect("dashboard.jsp");
	}
}
