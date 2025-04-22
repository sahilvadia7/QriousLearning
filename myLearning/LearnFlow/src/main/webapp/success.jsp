<%@page import="java.util.ArrayList"%>
<%@ page import="com.learnflow.model.Courses" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Courses course = null;

    if (request.getAttribute("courseDetails") != null) {
        course = (Courses) request.getAttribute("courseDetails");
    } else if (request.getAttribute("CourseInDetail") != null) {
        course = (Courses) request.getAttribute("CourseInDetail");
    } else if (request.getAttribute("addedCourse") != null) {
        course = (Courses) request.getAttribute("addedCourse");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Course Information</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f9f9f9;
            margin: 0;
            padding: 40px;
        }
        .container {
            max-width: 700px;
            margin: auto;
            background: white;
            border-radius: 16px;
            padding: 30px;
            box-shadow: 0 0 15px rgba(0,0,0,0.15);
        }
        .success-popup {
            background-color: #e0f7e9;
            color: #2e7d32;
            padding: 15px 20px;
            border-left: 6px solid #43a047;
            margin-bottom: 25px;
            border-radius: 10px;
        }
        .course-details h2 {
            margin-bottom: 10px;
            color: #444;
        }
        .course-details p {
            margin: 8px 0;
        }
        .explore-link {
            margin-top: 30px;
        }
        .explore-link a {
            background: #6200ea;
            color: white;
            padding: 10px 20px;
            border-radius: 10px;
            text-decoration: none;
        }
        .explore-link a:hover {
            background: #3700b3;
        }
    </style>
</head>
<body>

<div class="container">

<% if (course != null) { %>
    <div class="success-popup">
        <%= request.getAttribute("courseDetails") != null ? " Course Details" : " Course added successfully!" %>
    </div>

    <div class="course-details">
        <h2><%= course.getTitle() %></h2>
        <p><strong>Description:</strong> <%= course.getDescription() %></p>
        <p><strong>Price:</strong> ₹<%= course.getPrice() %> (<%= course.getDiscounted_price() %> after discount)</p>
        <p><strong>Duration:</strong> <%= course.getDuration() %> hours</p>
        <p><strong>Languages:</strong> 
            <%= course.getLanguage() != null ? String.join(", ", course.getLanguage()) : "N/A" %>
        </p>
        
        <p><strong>Category ID:</strong> <%= course.getCategory_id().getCategory_id() %></p>
        <p><strong>Instructor ID:</strong> <%= course.getInstructor_id().getUser_id() %></p>
    </div>

    <div class="explore-link">
        <a href="explore.jsp">🔍 View in Explore Section</a>
    </div>
<% } else { %>
    <div class="success-popup" style="background-color: #ffebee; color: #c62828;">
        Course data is not available.
    </div>
<% } %>

</div>

</body>
</html>
