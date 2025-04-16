<%@ page import="com.jpa.model.Users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.jpa.model.Users.ROLE"%>

<%
    Users user = (Users) session.getAttribute("activeUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #e3f2fd;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #007BFF;
            color: white;
            padding: 15px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar h1 {
            margin: 0;
            font-size: 20px;
        }

        .navbar a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            padding: 8px 16px;
            border: 1px solid white;
            border-radius: 6px;
            transition: background-color 0.3s;
        }

        .navbar a:hover {
            background-color: white;
            color: #007BFF;
        }

        .container {
            padding: 50px;
            text-align: center;
        }

        .container h2 {
            color: #333;
        }

        .container p {
            font-size: 18px;
            color: #555;
        }
        
        .userdata {
            padding: 10px 20px;
            text-decoration: none;
            background-color: #007BFF;
            color: white;
            border-radius: 8px;
            font-weight: bold;
            transition: background-color 0.3s ease;
            
        }

     	 .userdata:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <h1>Welcome Portal</h1>
        <%
        session.setAttribute("activeUser", user);
        %>
        
        
        
        <a href="logout.jsp">Logout</a>
    </div>

    <div class="container">
        <h2>Hello, <%= user.getName() %></h2>
        <p>You have successfully logged in.</p>
        <p>Welcome to your dashboard.</p>
        
        <%if(user.getRole().equals(ROLE.ADMIN)){%>
        <a class ="userdata" href="users">Show User Data</a>
        
        
        <%} %>
    </div>

</body>
</html>
