package com.learnflow.repository;

import com.learnflow.model.Courses;
import com.learnflow.model.Users;
import com.learnflow.model.Categories;

import java.sql.*;
import java.util.*;

public class CourseRepository {

    private final String URL = "jdbc:postgresql://localhost:5433/learnflow";
    private final String USER = "postgres";
    private final String PASS = "root";
    
    
    
    public List<Courses> getCoursesByInstructor(int instructorId) {
        List<Courses> courses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT c.course_id, c.title, COUNT(enrollment.student_id) AS student_count "
                       + "FROM courses c "
                       + "JOIN enrollments enrollment ON c.course_id = enrollment.course_id "
                       + "WHERE c.instructor_id = ? "
                       + "GROUP BY c.course_id, c.title";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, instructorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Courses course = new Courses();
                course.setCourse_id(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
//                course.setStudentCount(rs.getInt("student_count"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }


    public List<Courses> getAllCourses() {
        List<Courses> courses = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            String sql = "SELECT c.*, u.username AS instructor_username, u.firstname AS instructor_firstname, u.lastname AS instructor_lastname, cat.name AS category_name \n"
            		+ "FROM courses c \n"
            		+ "JOIN users u ON c.instructor_id = u.user_id \n"
            		+ "JOIN categories cat ON c.category_id = cat.id";


            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Courses course = new Courses();

                course.setCourse_id(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));

                Users instructor = new Users();
                instructor.setUsername(rs.getString("instructor_username"));
                instructor.setfirstname(rs.getString("instructor_firstname"));
                instructor.setlastname(rs.getString("instructor_lastname"));
                course.setInstructor_id(instructor);

                Categories category = new Categories();
                category.setName(rs.getString("category_name"));
                course.setCategory_id(category);

                course.setPrice(rs.getInt("price"));
                course.setDiscounted_price(rs.getInt("discounted_price"));
                course.setDuration(rs.getDouble("duration"));

                String languageStr = rs.getString("language");
                if (languageStr != null) {
                    course.setLanguage(Arrays.asList(languageStr.split(",")));
                } else {
                    course.setLanguage(Collections.singletonList("N/A"));
                }

                course.setCreated_at(rs.getDate("created_at"));
                course.setUpdated_at(rs.getDate("updated_at"));

                courses.add(course);
            }


            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }
    
    public List<Courses> getCoursesByStudent(int studentId) {
        List<Courses> courses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT c.course_id, c.title "
                       + "FROM courses c "
                       + "JOIN enrollments enrollment ON c.course_id = enrollment.course_id "
                       + "WHERE enrollment.student_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Courses course = new Courses();
                course.setCourse_id(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
