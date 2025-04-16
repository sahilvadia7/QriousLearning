package com.lifecycleofservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleOfServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet is being initialized...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello from service method!</h1>");
        
        destroy();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is being destroyed...");
    }
}
