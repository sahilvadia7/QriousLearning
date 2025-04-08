package com.fisrtservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		
		PrintWriter out = response.getWriter();	

		int result=0;
		
		Cookie[] cookie = request.getCookies();
		
		for(Cookie i: cookie) {
			if(i.getName().equals("result")) {
				result = Integer.parseInt(i.getValue());
			}
		}
		
		out.print("Square : "+result);
	}
}
