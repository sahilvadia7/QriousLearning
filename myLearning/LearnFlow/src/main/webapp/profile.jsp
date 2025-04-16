<%@page import="com.learnflow.enums.Role"%>
<%@page import="com.learnflow.model.Users"%>
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
    <title>Learn Flow | Profile</title>
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
            background-color: var(--gray);
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
        

        .header-child {
            background: var(--white);
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .logo {
            font-size: 24px;
            font-weight: bold;
            color: var(--purple);
        }

        .container {
            max-width: 900px;
            margin: 30px auto;
            background-color: var(--white);
        	border: 2px solid #6A0DAD;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.05);
        }

        h2 {
            color: var(--purple);
            margin-bottom: 20px;
        }

        .profile-row {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .profile-item {
            flex: 1 1 45%;
            background-color: var(--gray);
            /* border: 1px solid #6A0DAD; */
            
            padding: 15px 20px;
            border-radius: 10px;
        }

        .label {
            font-weight: bold;
            color: var(--text);
        }

        .value {
            color: #444;
            margin-top: 5px;
        }

        .role-badge {
            display: inline-block;
            background-color: var(--purple);
            color: white;
            padding: 4px 10px;
            border-radius: 20px;
            font-size: 14px;
            margin-top: 5px;
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
        <a href=dashboard.jsp>My Learning</a>
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

<div class="header-child">
    <div class="role">Welcome, <%= user.getUsername() %> (<%= role.name() %>)</div>
</div>

<div class="container">
    <h2>Your Profile</h2>
    <div class="profile-row">
    
    <div class="profile-item">
            <div class="label">Username</div>
            <div class="value"><%= user.getUsername() %></div>
        </div>
        <div class="profile-item">
            <div class="label">First Name</div>
            <div class="value"><%= user.getfirstname() %></div>
        </div>
        <div class="profile-item">
            <div class="label">Last Name</div>
            <div class="value"><%= user.getlastname() %></div>
        </div>
        <div class="profile-item">
            <div class="label">Email</div>
            <div class="value"><%= user.getEmail() %></div>
        </div>
        <div class="profile-item">
            <div class="label">Role</div>
            <div class="value role-badge"><%= user.getRole() %></div>
        </div>
        <div class="profile-item" style="flex: 1 1 100%;">
            <div class="label">Bio</div>
            <div class="value"><%= user.getBio() != null ? user.getBio() : "No bio available." %></div>
        </div>
    </div>
</div>

</body>
</html>
