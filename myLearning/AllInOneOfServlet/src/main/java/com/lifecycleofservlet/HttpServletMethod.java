package com.lifecycleofservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletMethod extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        PrintWriter out = res.getWriter();
	        out.println("<h1>Hello from doGet method!</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        if (name != null && !name.isEmpty()) {
            out.println("Welcome, " + name);
        } else {
            out.println("Username not provided");
        }
    }

}
