<%@page import="com.learnflow.enums.Role"%>
<%@page import="com.learnflow.model.Users"%>
<%@ page import="java.util.*" %>
<%@ page session="true" %>
<%
    Users user = (Users) session.getAttribute("loggedInUser");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    Role role = user.getRole();
    if (role == null) {
        role = Role.STUDENT;
        user.setRole(role);
    }
    session.setAttribute("role", role.name());
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Learn Flow | Dashboard</title>
    <style>
        :root {
            --purple: #6A0DAD;
            --gray: #f5f5f5;
            --white: #fff;
            --text: #2c2c2c;
        }

        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: var(--gray);
        }
        
         /* HEADER */
        .header {
            background-color: var(--white);
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 15px 30px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            color: var(--purple);
        }

        .search-bar {
            flex: 1;
            max-width: 500px;
            margin: 0 30px;
        }

        .search-bar input {
            width: 100%;
            padding: 10px 15px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 16px;
        }

        .nav-links a {
            margin-left: 20px;
            color: var(--purple);
            text-decoration: none;
            font-weight: 500;
        }
        

        .child-header {
            background: var(--white);
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .logo {
            font-size: 22px;
            font-weight: bold;
            color: var(--purple);
        }

        .role {
            font-weight: bold;
            color: var(--text);
        }

        .dashboard {
            padding: 30px;
        }

        .card {
            background: var(--white);
            padding: 20px;
            border: 2px solid #6A0DAD;
            
            margin: 15px 0;
            border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }

        .card h3 {
            margin-top: 0;
            color: var(--purple);
        }

        .btn {
            background: var(--purple);
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            margin-top: 10px;
            cursor: pointer;
        }

        .table {
            width: 100%;
            margin-top: 10px;
            border-collapse: collapse;
        }

        .table th, .table td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .table th {
            text-align: left;
            background-color: #eee;
        }

       </style>
</head>
<body>

<!-- HEADER -->
<div class="header">
    <div class="logo">Learn Flow</div>
    <div class="search-bar">
        <input type="text" placeholder="Search for anything...">
    </div>
    <div class="nav-links">
        <a href="explore.jsp">Explore</a>
       
		 <%
    String role1 = (String) session.getAttribute("role");
    if ("STUDENT".equals(role1)) {
%>
		
        <a href="dashboard.jsp">My Learning</a>
<%
    } else if ("INSTRUCTOR".equals(role1)) {
%>
        <a href="dashboard.jsp">My Course</a>
<%
    } else {
%>
        <a href="dashboard.jsp">Manage user</a>
<%
    }
%>

        <a href="profile.jsp">Profile</a>
        <a href="logout">Logout</a>
    </div>
</div>

<!-- CHILD HEADER -->
<div class="child-header">
    <div class="role">Welcome, <%= user.getUsername() %> (<%= role.name() %>)</div>
</div>

<!-- DASHBOARD BODY -->
<div class="dashboard">
    <% if (role.equals(Role.STUDENT)) { %>
        <jsp:include page="student-dashboard.jsp" />
    <% } else if (role.equals(Role.INSTRUCTOR)) { %>
        <jsp:include page="instructor-dashboard.jsp" />
    <% } else if (role.equals(Role.ADMIN)) { %>
        <jsp:include page="admin-dashboard.jsp" />
    <% } %>
</div>

</body>
</html>
