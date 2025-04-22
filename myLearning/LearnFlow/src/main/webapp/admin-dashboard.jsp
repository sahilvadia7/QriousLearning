<%@page import="com.learnflow.model.Courses"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.learnflow.enums.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.learnflow.model.Users"%>
<% 

List<Users> allUsers = (List<Users>) session.getAttribute("allUsers");
List<Courses> getAllCourse = (List<Courses>) session.getAttribute("allCourse");

long studentCount = 0;
long instructorCount = 0;
long courseCount =0;

List<Users> students  = new ArrayList<>();
List<Users> instructors = new ArrayList<>();
List<Courses> courses = new  ArrayList<>();

if (allUsers != null) {
    studentCount = allUsers.stream()
                           .filter(u -> u.getRole().equals(Role.STUDENT))
                           .count();
    
 
    instructorCount = allUsers.stream()
            .filter(u -> u.getRole().equals(Role.INSTRUCTOR))
            .count();
    
    students = allUsers.stream()
    						.filter(student -> student.getRole().equals(Role.STUDENT))
    						.collect(Collectors.toList());
    
    instructors = allUsers.stream()
			.filter(student -> student.getRole().equals(Role.INSTRUCTOR))
			.collect(Collectors.toList());
    
}

if (getAllCourse != null) {
    courses = getAllCourse;
    courseCount = courses.size();
}

%>
 
 <div class="card">
    <h3>Platform Summary</h3>
    <p>Total Students: <%= studentCount %></p>
    <p>Total Instructor: <%= instructorCount %></p>
    <p>Total Courses: <%= courseCount %></p>
</div>
 
 
<div class="card">
    <h3>Manage Students</h3>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>

        <%
       
            if (students != null) {
                for (Users u : students) {
                	
                	
        %>
            <tr>
                <td><%= u.getUser_id() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getUsername() %></td>
                <td><%= u.getRole() %></td>
                <td>
                    <form action="editUser" method="get" style="display:inline;">
                        <input type="hidden" name="UuserId" value="<%= u.getUser_id() %>"/>
                        <button class="btn" type="submit">Edit</button>
                    </form>
                    
                    <form action="deleteUser" method="post" style="display:inline;">
                        <input type="hidden" name="DuserId" value="<%= u.getUser_id() %>"/>
                        <button class="btn" style="background-color:red;" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</div>







<div class="card">
    <h3>Manage Instructors</h3>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>

        <%
       
            if (instructors != null) {
                for (Users u : instructors) {
                	
                	
        %>
            <tr>
                <td><%= u.getUser_id() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getUsername() %></td>
                <td><%= u.getRole() %></td>
                <td>
                    <form action="updateUser" method="get" style="display:inline;">
                        <input type="hidden" name="userId" value="<%= u.getUser_id() %>"/>
                        <button class="btn" type="submit">Edit</button>
                    </form>
                    
                    <form action="deleteUser" method="post" style="display:inline;">
                        <input type="hidden" name="userId" value="<%= u.getUser_id() %>"/>
                        <button class="btn" style="background-color:red;" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</div>


<div class="card">
    <h3>All Registered Users</h3>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Email</th>
            <th>Username</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>

        <%
       
            if (allUsers != null) {
                for (Users u : allUsers) {
                	
                	
        %>
            <tr>
                <td><%= u.getUser_id() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getUsername() %></td>
                <td><%= u.getRole() %></td>
                <td>
                    <form action="updateUser" method="get" style="display:inline;">
                        <input type="hidden" name="userId" value="<%= u.getUser_id() %>"/>
                        <button class="btn" type="submit">Edit</button>
                    </form>
                    
                    <form action="deleteUser" method="post" style="display:inline;">
                        <input type="hidden" name="userId" value="<%= u.getUser_id() %>"/>
                        <button class="btn" style="background-color:red;" type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <%
                }
            }
        %>
    </table>
</div>
