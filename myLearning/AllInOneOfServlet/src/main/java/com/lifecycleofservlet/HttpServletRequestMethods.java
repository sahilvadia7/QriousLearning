package com.lifecycleofservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//✔ Methods Covered:
//getParameter()
//getParameterValues()
//getHeader()
//getCookies()
//getSession()
//getAttribute() / setAttribute()
//getRequestDispatcher()



public class HttpServletRequestMethods extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException  {
		
		
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<h1> HttpServletRequest Methods </h1>");
		
		String username = req.getParameter("username");
		String[] hobbies = req.getParameterValues("hobbies");
		
		String agent = req.getHeader("User-Agent");
        req.setAttribute("info", "data passed via setAttribute");
//
//        out.println("<h4>Welcome, back :"+username+"</h4>");
//        out.println("<h4>User-Agent"+agent+"</h4>");
//        out.println(req.getAttribute("info"));
        
        if (hobbies != null) {
            out.println("<h4>Hobbies: ");
            for (String h : hobbies) {
                out.print(h+",");
            }
//            out.println("</h4>");
        }
		
        
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        
        //using Response
        res.sendRedirect("dashboard.jsp");
        
        //using RequestDispathcher
//        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
//        rd.forward(req, res);
	}

}
