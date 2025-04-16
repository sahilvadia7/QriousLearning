<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }

        .card {
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            padding: 30px 40px;
            width: 300px;
            text-align: center;
        }

        .card h2 {
            color: #333;
            margin-bottom: 10px;
        }

        .card p {
            color: #666;
        }

        .logout {
            margin-top: 20px;
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .logout:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Welcome, <%= username != null? username : "Guest" %> 👋</h2>
        <p>This is your dashboard.</p>
    </div>
</body>
</html>
