package com.jpa.util;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.jpa.model.Users;
import com.jpa.model.Users.ROLE;

public class DBServlet extends HttpServlet {
    private static final String URL = "jdbc:postgresql://localhost:5433/jdbc_users";
    private static final String USER = "postgres";
    private static final String PASS = "root";

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Users> userList = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, email, id ,role FROM  \"Users\"");

            while (rs.next()) {
            	Users user = new Users();
            	user.setId(rs.getInt("id"));
            	user.setEmail(rs.getString("email"));
            	user.setName(rs.getString("username"));
            	user.setRole(ROLE.valueOf(rs.getString("Role").toUpperCase()));
                userList.add(user);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("dbuser", userList);
        RequestDispatcher rd = request.getRequestDispatcher("data.jsp");
        rd.forward(request, response);
    }
}
