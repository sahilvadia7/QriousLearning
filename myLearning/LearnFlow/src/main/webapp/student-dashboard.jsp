<%-- <%@page import="com.learnflow.model.Lecture"%>
 --%><%@page import="com.learnflow.model.Wishlists"%>
<%@page import="com.learnflow.model.Enrollments"%>
<%@page import="com.learnflow.model.Courses"%>
<%@page import="java.util.List"%>
<%
	
List<Enrollments> enrollmentsList = (List<Enrollments>) session.getAttribute("enrollmentsList");
/* List<Lecture> upcomingLectures = (List<Lecture>) session.getAttribute("upcomingLectures");
 */
 List<Wishlists> wishlistCourses = (List<Wishlists>) session.getAttribute("wishlistList");

%>

<!-- Enrollments -->
<div class="card">
    <h3>Your Enrollments</h3>
    <table class="table">
        <tr>
            <th>Enrollment ID</th>
            <th>Course Title</th>
            <th>Instructor</th>
            <th>Language</th>
            <th>Duration</th>
            <th>Description</th>
            <th>Completion Status</th>
            <th></th>
        </tr>

        <%
            if (enrollmentsList != null && !enrollmentsList.isEmpty()) {
                for (Enrollments enrollments : enrollmentsList) {
                    Courses course = enrollments.getCourse_id();
        %>
            <tr>
                <td><%= enrollments.getEnrollment_id() %></td>
                <td><%= course.getTitle() %></td>
                <td><%= course.getInstructor_id().getUser_id() %></td>
                <td><%= String.join(", ", course.getLanguage()) %></td>
                <td><%= course.getDuration() %></td>
                <td><%= course.getDescription() %></td>
                <td><%= enrollments.getCompletion_status() %></td>
				
                
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6">No enrollments yet.</td>
            </tr>
        <%
            }
        %>
    </table>
</div>

<!-- Upcoming Lectures -->
<%-- <div class="card">
    <h3>Upcoming Lectures</h3>
    <ul>
        <%
            if (upcomingLectures != null && !upcomingLectures.isEmpty()) {
                for (Lecture lec : upcomingLectures) {
        %>
            <li><%= lec.getLecture_date() %> - <%= lec.getTitle() %></li>
        <%
                }
            } else {
        %>
            <li>No upcoming lectures.</li>
        <%
            }
        %>
    </ul>
</div> --%>

<!-- Wishlist -->
<!-- Wishlist -->
<div class="card">
    <h3>Your Wishlist</h3>
    <table class="table">
        <tr>
            <th>Wishlist ID</th>
            <th>Course Title</th>
            <th>Instructor</th>
            <th>Language</th>
            <th>Duration</th>
            <th>Description</th>
        </tr>

        <%
            if (wishlistCourses != null && !wishlistCourses.isEmpty()) {
                for (Wishlists wish : wishlistCourses) {
                    Courses course = wish.getCourse_id();
        %>
            <tr>
                <td><%= wish.getWishlist_item_id() %></td>
                <td><%= course.getTitle() %></td>
<td>
  <%= (course.getInstructor_id() != null) ? course.getInstructor_id().getUser_id() : "N/A" %>
</td>
                <td><%= String.join(", ", course.getLanguage()) %></td>
                <td><%= course.getDuration() %></td>
                <td><%= course.getDescription() %></td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="6">Your wishlist is empty.</td>
            </tr>
        <%
            }
        %>
    </table>
</div>

