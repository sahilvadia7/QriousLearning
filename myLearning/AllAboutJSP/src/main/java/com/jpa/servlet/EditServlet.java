package com.jpa.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpa.dao.UserDao;
import com.jpa.model.Users;

public class EditServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		String username= request.getParameter("username");
		String email = request.getParameter("email");
		
		Users OPUser = new Users();
		OPUser.setId(id);
		OPUser.setEmail(email);
		OPUser.setName(username);
	    UserDao userDAO = new UserDao();

		if(action.equalsIgnoreCase("edit")) {
		        boolean editSuccess = userDAO.updateUser(OPUser);
		        
		        if (editSuccess) {
		            System.out.println("updated!");
		            response.sendRedirect("users");
		        } else {
		        	System.out.println("something wrong");
		        }
		        
		}else if(action.equalsIgnoreCase("delete")) {
			boolean deleteSuccess = userDAO.deleteUser(OPUser);
			
			if(deleteSuccess) {
				System.out.println("deleted!");
				response.sendRedirect("users");
			}else {
				System.out.println("something wrong");
			}
		}
		
	        
	     
		
	}
}
