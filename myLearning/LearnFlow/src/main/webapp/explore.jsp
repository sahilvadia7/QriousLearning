<%@page import="com.learnflow.enums.Role"%>
<%@page import="com.learnflow.repository.CourseRepository"%>
<%@page import="com.learnflow.model.*"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%    Users user = (Users) session.getAttribute("loggedInUser"); %>
<%    String role1 = (String) session.getAttribute("role"); %>
<%
    CourseRepository courseDao = new CourseRepository();
    List<Courses> allCourses = courseDao.getAllCourses();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Explore Courses | Learn Flow</title>
<style>
:root {
	--purple: #6A0DAD;
	--gray: #f5f5f5;
	--white: #fff;
	--text: #333;
}

body {
	font-family: 'Segoe UI', sans-serif;
	margin: 0;
	background: var(--gray);
}

/* HEADER */
.header {
	background-color: var(--white);
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 15px 30px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
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
	padding: 20px 30px;
	font-size: 24px;
	font-weight: bold;
	color: var(--purple);
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.section-title {
	margin: 30px 0 10px 30px;
	font-size: 20px;
	color: var(--text);
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	padding: 20px;
	justify-content: center;
}

.card {
	background-color: #fff;
	border: 2px solid #6A0DAD;
	border-radius: 12px;
	padding: 20px;
	width: 300px;
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.05);
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.card h3 {
	color: #6A0DAD;
	font-size: 20px;
	margin-bottom: 10px;
}

.card p {
	color: #333;
	font-size: 14px;
	margin-bottom: 6px;
}

.price {
	font-size: 16px;
	font-weight: bold;
	color: #000;
}

.old-price {
	text-decoration: line-through;
	color: gray;
	font-size: 14px;
	margin-left: 8px;
}

.card-buttons {
	display: flex;
	justify-content: space-between;
	margin-top: 15px;
}

.card-buttons button {
	flex: 1;
	margin: 5px;
	padding: 10px;
	background-color: #6A0DAD;
	color: white;
	border: none;
	min-width: 135px;
	border-radius: 8px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	font-size: 14px;
}

.card-buttons button:hover {
	background-color: #540f94;
}

form {
	width: 100%;
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
        if(user!=null){
        %>

			<%
        		
  
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

			<a href="profile.jsp">Profile</a> <a href="logout">Logout</a>

			<%}else{ %>
			<a href="login.jsp">Login</a>

			<%} %>



		</div>
	</div>

	<div class="header-child">Explore Courses</div>

	<!-- All Courses -->
	<div class="section-title">All Courses</div>
	<div class="card-container">
		<% for (Courses course : allCourses) { %>
		<div class="card">
			<h3><%= course.getTitle() %></h3>
			<p><%= course.getDescription().length() > 80 ? course.getDescription().substring(0, 80) + "..." : course.getDescription() %></p>
			<p>
				Instructor: <strong><%= course.getInstructor_id().getUsername() %></strong>
			</p>
			<p>
				Category:
				<%= course.getCategory_id().getName() %></p>
			<p>
				Duration:
				<%= course.getDuration() %>
				hrs
			</p>
			<p>
				Languages:
				<%= String.join(", ", course.getLanguage()) %></p>
			<p class="price">
				₹<%= course.getDiscounted_price() %>
				<span class="old-price">₹<%= course.getPrice() %></span>
			</p>
			<div class="card-buttons">
				<% 
            
            if(user!=null){ %>
				<form action="requestToUserAction" method="post">
					<input type="hidden" name="actionCourseId"
						value="<%= course.getCourse_id() %>">
					<%if ("STUDENT".equals(role1)) { %>
					<button type="submit" name="action" value="enroll">Enroll</button>
					<button type="submit" name="action" value="wishlist">Add to Wishlist</button>
					<%}else if("INSTRUCTOR".equals(role1) && user.getUsername().equals(course.getInstructor_id().getUsername())) {%>
					<button type="submit" name="action" value="courseDetails">See details</button>
					<%} else if("ADMIN".equals(role1)){ %>
					<button type="submit" name="action" value="courseInsight">Course Insight</button>
					<%} else{%>
					
					<%} %>
				</form>

				<%}else{ %>
				<form action="login.jsp">
					<button type="submit">Enroll to Login</button>
				</form>
				<%} %>
			</div>
		</div>
		<% } %>
	</div>

	<!-- Popular Courses (Static for now, you can filter/sort by enrollments later) -->
	<div class="section-title">Popular Courses</div>
	<div class="card-container">
		<% for (Courses course : allCourses.subList(0, Math.min(4, allCourses.size()))) { %>
		<div class="card">
			<h3><%= course.getTitle() %></h3>
			<p><%= course.getDescription().length() > 80 ? course.getDescription().substring(0, 80) + "..." : course.getDescription() %></p>
			<p>
				Instructor: <strong><%= course.getInstructor_id().getUsername() %></strong>
			</p>
			<p>
				Category:
				<%= course.getCategory_id().getName() %></p>
			<p>
				Duration:
				<%= course.getDuration() %>
				hrs
			</p>
			<p>
				Languages:
				<%= String.join(", ", course.getLanguage()) %></p>
			<p class="price">
				₹<%= course.getDiscounted_price() %>
				<span class="old-price">₹<%= course.getPrice() %></span>
			</p>
			<div class="card-buttons">
				<% 
            
            if(user!=null){ %>
				<form action="requestToUserAction" method="post">
					<input type="hidden" name="actionCourseId"
						value="<%= course.getCourse_id() %>">
					<%if ("STUDENT".equals(role1)) { %>
					<button type="submit" name="action" value="enroll">Enroll</button>
					<button type="submit" name="action" value="wishlist">Add
						to Wishlist</button>
					<%}else if("INSTRUCTOR".equals(role1) && user.getUsername().equals(course.getInstructor_id().getUsername())) {%>
					<button type="submit" name="action" value="courseDetails">See
						details</button>
					<%} else if("ADMIN".equals(role1)){ %>
					<button type="submit" name="action" value="courseInsight">Course
						Insight</button>
					<%} else{%>
					
					<%} %>
					
					</form>

				<%}else{ %>
				<form action="login.jsp">
					<button type="submit">Enroll to Login</button>
				</form>
				<%} %>
			</div>
		</div>
		<% } %>
	</div>

	<% 
    Map<String, List<Courses>> instructorCourseMap = new HashMap<>();
    
    for (Courses course : allCourses) {
        String instructorName = course.getInstructor_id().getfirstname(); 
        instructorCourseMap.putIfAbsent(instructorName, new ArrayList<>());
        instructorCourseMap.get(instructorName).add(course);
    }
%>

	<% for (Map.Entry<String, List<Courses>> entry : instructorCourseMap.entrySet()) { 
    String instructorName = entry.getKey();
    List<Courses> coursesByInstructor = entry.getValue();
%>
	<div class="section-title">
		Courses by
		<%= instructorName %></div>
	<div class="card-container">
		<% for (Courses course : coursesByInstructor.subList(0, Math.min(4, coursesByInstructor.size()))) { %>
		<div class="card">
			<h3><%= course.getTitle() %></h3>
			<p><%= course.getDescription().length() > 80 ? course.getDescription().substring(0, 80) + "..." : course.getDescription() %></p>
			<p>
				Instructor: <strong><%= course.getInstructor_id().getUsername() %></strong>
			</p>
			<p>
				Category:
				<%= course.getCategory_id().getName() %></p>
			<p>
				Duration:
				<%= course.getDuration() %>
				hrs
			</p>
			<p>
				Languages:
				<%= String.join(", ", course.getLanguage()) %></p>
			<p class="price">
				₹<%= course.getDiscounted_price() %>
				<span class="old-price">₹<%= course.getPrice() %></span>
			</p>

			<div class="card-buttons">
				<% 
            
            if(user!=null){ %>
				<form action="requestToUserAction" method="post">
					<input type="hidden" name="actionCourseId"
						value="<%= course.getCourse_id() %>">
					<%if ("STUDENT".equals(role1)) { %>
					<button type="submit" name="action" value="enroll">Enroll</button>
					<button type="submit" name="action" value="wishlist">Add
						to Wishlist</button>
					<%}else if("INSTRUCTOR".equals(role1) && user.getUsername().equals(course.getInstructor_id().getUsername())) {%>
					<button type="submit" name="action" value="courseDetails">See
						details</button>
					<%} else if("ADMIN".equals(role1)){ %>
					<button type="submit" name="action" value="courseInsight">Course
						Insight</button>
					<%} else{%>
					
					<%} %>
				</form>


				<%}else{ %>
				<form action="login.jsp">
					<button type="submit">Enroll to Login</button>
				</form>
				<%} %>
			</div>
		</div>
		<% } %>
	</div>
	<% } %>


	</div>


</body>
</html>
