package com.fisrtservlet;

import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int result = num1 + num2;

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<h2>Result is: " + result + "</h2>");
        
//        request.setAttribute("result", response);
//        
//        RequestDispatcher rd = request.getRequestDispatcher("SquareServlet");
//        rd.forward(request, response);
        

        //sendRediract {url rewriting}
//        response.sendRedirect("SquareServlet?result="+result);
        
//        session
//        HttpSession session = request.getSession();
//        session.setAttribute("result", result);
        
        
//        Cookie
        Cookie cookie = new Cookie("result", result+"");
        response.addCookie(cookie);
        
        response.sendRedirect("SquareServlet");

    }
}

