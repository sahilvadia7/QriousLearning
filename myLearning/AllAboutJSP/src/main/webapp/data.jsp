<%@page import="com.jpa.model.Users.ROLE"%>
<%@page import="com.jpa.model.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Users sessionUser = (Users) session.getAttribute("activeUser");

	System.out.println(sessionUser.getRole());
if (sessionUser == null || sessionUser.getRole() == null || !sessionUser.getRole().equals(ROLE.ADMIN)) {
    response.sendRedirect("notallowed403.jsp");
    return;
}


%>
<!DOCTYPE html>
<html>
<head>
    <title>PostgreSQL JSP User List</title>
   <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            padding: 40px;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .nodata {
            color: red;
            font-style: italic;
        }

        .action-btn {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
        }

        .edit-btn {
            background-color: #28a745;
            color: white;
        }

        .delete-btn {
            background-color: #dc3545;
            color: white;
        }

        input[type="text"], input[type="email"] {
            width: 90%;
            padding: 5px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>PostgreSQL User List</h2>
    <%
    
        List<Users> users = (List<Users>) request.getAttribute("dbuser");
        if (users != null && !users.isEmpty()) {
    %>
    <table>
        <tr>
            <th>#</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <%
            int count = 1;
            for (Users user : users) {
        %>
        <tr>
            <form action="EditServlet" method="post">
                <td><%= count++ %></td>
                <td><input type="text" name="username" value="<%= user.getName() %>" /></td>
                <td><input type="text" name="email" value="<%= user.getEmail() %>" /></td>
				<td><input type="text" name="role" value="<%= user.getRole() %>" /></td>
                
                <td>
					<input type="hidden" name="id" value="<%= user.getId()%>" />
					<input type="hidden" name="user" value="<%= user %>" />
					
                    <button type="submit" name="action" value="edit" class="action-btn edit-btn">Edit</button>
                    <button type="submit" name="action" value="delete" class="action-btn delete-btn">Delete</button>
                </td>
            </form>
        </tr>
        <% } %>
    </table>
    <% } else { %>
        <p class="nodata">No data found.</p>
    <% } %>
</div>

</body>
</html>
