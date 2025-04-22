<%@page import="java.util.ArrayList"%>
<%@page import="com.learnflow.model.Categories"%>
<%@page import="com.learnflow.model.Users"%>
<%@page import="com.learnflow.model.Reviews"%>
<%@page import="com.learnflow.model.Courses"%>
<%@ page import="java.util.List" %>

<%
    Users currentUser = (Users) session.getAttribute("user");
List<Courses> instructorCourses = (List<Courses>) session.getAttribute("instructorCourses");
    List<Reviews> courseReviews = (List<Reviews>) request.getAttribute("courseReviews");
    List<Categories> allCategoriesList = (List<Categories>) session.getAttribute("allCategories");
    
    System.out.println("in the top instructor jsp");
    System.out.println(allCategoriesList);
    if (allCategoriesList == null) {
        allCategoriesList = new ArrayList<>();
    }
%>

<!-- CSS -->
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', sans-serif;
        background-color: #f9f9fb;
    }

    .page-wrapper {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 40px 20px;
    }

    .card {
        background-color: #fff;
        border: 2px solid #7c3aed;
        border-radius: 16px;
        padding: 30px;
        margin: 20px 0;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
        max-width: 800px;
        width: 100%;
    }

    .card h3 {
        font-size: 24px;
        margin-bottom: 20px;
        color: #7c3aed;
        text-align: center;
    }

    .card form input,
    .card form textarea,
    .card form select {
        width: 100%;
        padding: 12px 16px;
        margin-bottom: 16px;
        border: 1px solid #d1d5db;
        border-radius: 8px;
        font-size: 16px;
        box-sizing: border-box;
        transition: border 0.3s;
    }

    .card form input:focus,
    .card form textarea:focus,
    .card form select:focus {
        outline: none;
        border-color: #7c3aed;
        box-shadow: 0 0 0 2px rgba(124, 58, 237, 0.2);
    }

    .card .btn {
        background-color: #7c3aed;
        color: white;
        font-size: 16px;
        font-weight: 600;
        border: none;
        border-radius: 8px;
        padding: 12px 20px;
        cursor: pointer;
        width: 100%;
        transition: background-color 0.3s ease;
    }

    .card .btn:hover {
        background-color: #5b21b6;
    }

    .table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 16px;
    }

    .table th,
    .table td {
        padding: 12px 16px;
        border-bottom: 1px solid #e5e7eb;
        text-align: left;
    }

    ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    ul li {
        padding: 8px 0;
        border-bottom: 1px solid #e5e7eb;
    }
</style>

<style>
    .refresh-btn {
        background-color: transparent;
        color: #7c3aed;
        border: 2px solid #7c3aed;
        border-radius: 8px;
        padding: 6px 12px;
        font-size: 14px;
        font-weight: 600;
        cursor: pointer;
        transition: background-color 0.3s ease, color 0.3s ease;
    }

    .refresh-btn:hover {
        background-color: #7c3aed;
        color: white;
    }
    
  
</style>

<div class="page-wrapper">

    <div class="card">
    
    <% 
    List<String> errors = (List<String>) request.getAttribute("errors");
    if (errors != null && !errors.isEmpty()) {
%>
    <div style="color: red; padding: 10px; border: 1px solid red; margin-bottom: 10px;">
        <ul>
        <% for (String err : errors) { %>
            <li><%= err %></li>
        <% } %>
        </ul>
    </div>
<% } %>
    
<%
    if (allCategoriesList == null || allCategoriesList.isEmpty()) {
%>
    <div style="color: red; padding: 10px; border: 1px solid red; margin-bottom: 10px;">
        Categories not found. Please <a href="/categories">load categories</a>.
    </div>
<%
    }
%>
        <h3>Add New Course</h3>
        <form action="addCourse" method="post">
            <input type="text" name="title" placeholder="Course Title" required><br>
            <textarea name="description" placeholder="Course Description" rows="3" required></textarea><br>
            <input type="number" name="price" placeholder="Price (₹)" required><br>
            <input type="number" name="discounted_price" placeholder="Discounted Price (₹)" required><br>
            <input type="number" name="duration" placeholder="Duration (hours)" step="0.1" required><br>
            <input type="text" name="language" placeholder="Languages (comma separated)" required><br>
            <select name="category_id" required>
    <option value="">Select Category</option>
    <% for(Categories categorie : allCategoriesList) { %>
        <option value="<%= categorie.getCategory_id() %>">
            <%= categorie.getName() %>
        </option>
    <% } %>
    
    
</select><br>

            <button class="btn">Upload Course</button>
        </form>
    </div>


<div class="card">
    <div style="display: flex; justify-content: space-between; align-items: center;">
        <h3>Your Courses & Enrollments</h3>
        <form action="fetchInstructorCourse" method="Post" style="margin: 0;">
            <button class="refresh-btn" type="submit" name="refresh" value="true"> Refresh</button>
        </form>
    </div>
    <table class="table">
        <tr>
            <th>Course</th>
            <th>Description</th>
            <th>Students Enrolled</th>
            <th>Actions</th>
            
        </tr>
        <% if (instructorCourses != null) {
            for (Courses course : instructorCourses) { %>
                <tr>
                    <td><%= course.getTitle() %></td>
                    <td> <%= course.getDescription() %> </td>
                     <td><%= course.getStudentCount() %></td>
                    <td> 
                    <form action="editCourse" method="get">
					    <input type="hidden" name="courseId" value="<%= course.getCourse_id() %>">
					    <button class="edit-button">Edit</button>
					</form>

					<form action="deleteCourse" method="post" onsubmit="return confirm('Are you sure?');">
					    <input type="hidden" name="courseId" value="<%= course.getCourse_id() %>">
					    <button class="delete-button">Delete</button>
					</form>

                     </td>
                </tr>
        <%  } } else { %>
            <tr><td colspan="2">No courses available</td></tr>
        <% } %>
    </table>
</div>


    <div class="card">
        <h3>Latest Course Reviews</h3>
        <ul>
            <% if (courseReviews != null) {
                for (Reviews review : courseReviews) { %>
                    <li>"<%= review.getComment() %>" - ⭐⭐⭐⭐⭐</li>
            <%  } } else { %>
                <li>No reviews yet.</li>
            <% } %>
        </ul>
    </div>

</div>
