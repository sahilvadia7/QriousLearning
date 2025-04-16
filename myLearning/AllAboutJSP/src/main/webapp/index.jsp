<%@page import="com.jpa.model.Users"%>
<%@ page import="com.jpa.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<style>
    .error-msg {
        display: none;
        color: red;
        font-weight: bold;
        margin-top: 10px;
        padding: 10px;
        background-color: #ffe6e6;
        border: 1px solid red;
        border-radius: 5px;
    }

    .error-msg.visible {
        display: block;
    }

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

.form-container input[type="text"], .form-container input[type="email"],
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
</style>
</head>
<body>

	<div class="form-container">
		<h2>Register</h2>
		<form method="post">
			<input type="text" name="username" placeholder="Username" required />
			<input type="email" name="email" placeholder="Email" required /> <input
				type="password" name="password" placeholder="Password" required />
			<input type="submit" value="Register">
		</form>

	<a href="login.jsp"> Login</a>
		<%
    String error = (String) request.getAttribute("error");
    boolean hasError = error != null && !error.trim().isEmpty();
%>
<p id="error-msg" class="error-msg <%= hasError ? "visible" : "" %>">
    <%= hasError ? error : "" %>
</p>




	</div>

	<%
	if ("POST".equalsIgnoreCase(request.getMethod())) {

		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Users user = new Users();
		user.setName(username);
		user.setEmail(email);
		user.setPassword(password);

		session.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("handleRegister");
		dispatcher.forward(request, response);
	}
	%>


</body>
</html>
