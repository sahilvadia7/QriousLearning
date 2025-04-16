<%@page import="java.util.Set"%>
<%@page import="com.jpa.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .form-container input[type="email"],
        .form-container input[type="password"] {
            width: 100%;
            padding: 12px 15px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
        }

        .form-container input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #007BFF;
            border: none;
            border-radius: 8px;
            color: white;
            font-weight: bold;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .form-container .message {
            margin-top: 15px;
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Login</h2>
        <form method="post">
            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />
            <input type="submit" value="Login">
        </form>
        
        

        <%
        
        RequestDispatcher logindispatcher = request.getRequestDispatcher("handleLogin");
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                
                Users loginData = new Users();
                loginData.setEmail(email);
                loginData.setPassword(password);

                if (email!=null&&password!=null) {
                    session.setAttribute("logindata", loginData);
                    logindispatcher.forward(request, response);
                } else {
        %>
            <div class="message">Invalid email or password</div>
			<a href="Register.jsp">Register</a>            
        <%
                }
            }
        %>
        
        	<a href="index.jsp"> Register	</a>
        
    </div>

</body>
</html>
