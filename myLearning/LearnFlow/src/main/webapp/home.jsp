<%@page import="com.learnflow.enums.Role"%>
<%@ page import="java.util.List" %>
<%@ page import="com.learnflow.model.Categories" %>
<%@ page session="true" %>
<%
    List<Categories> categoryList = (List<Categories>) request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Learn Flow | Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        :root {
            --purple: #6A0DAD;
            --white: #fff;
            --gray: #f5f5f5;
            --text: #2c2c2c;
        }

        body {
            margin: 0;
            font-family: "Segoe UI", sans-serif;
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

        /* CATEGORY TABS */
        .categories {
            background-color: var(--white);
            display: flex;
            padding: 10px 30px;
            overflow-x: auto;
            border-bottom: 1px solid #eee;
        }

        .categories a {
            margin-right: 20px;
            color: var(--text);
            font-weight: 500;
            white-space: nowrap;
            text-decoration: none;
        }

        .categories a:hover {
            color: var(--purple);
        }

        .welcome {
            padding: 40px 30px;
        }

        .welcome h2 {
            margin-bottom: 10px;
            color: var(--purple);
        }

        .welcome p {
            color: var(--text);
        }

        @media(max-width: 768px) {
            .nav-links a {
                margin-left: 10px;
            }
            .search-bar {
                margin: 10px 0;
            }
        }
    </style>
</head>
<body>

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
    } else if("ADMIN".equals(role1)){
%>
        <a href="dashboard.jsp">Manage user</a>
<%
    }else { }
%>
        <a href="profile.jsp">Profile</a>
        <a href="logout">Logout</a>
    </div>
</div>

<div class="categories">
 <% if (categoryList != null) {
        for (Categories cat : categoryList) { %>
            <a href="#"><%= cat.getName() %></a>
    <%  }} %> 
</div>

<div class="welcome">
    <h2>Welcome to Learn Flow!</h2>
    <p>Discover your favorite topics and start learning now.</p>
</div>

</body>
</html>
