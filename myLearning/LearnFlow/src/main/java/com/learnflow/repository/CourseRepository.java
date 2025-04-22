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
            String sql = "SELECT c.course_id, c.title, c.description, c.instructor_id, c.category_id, " +
                         "c.price, c.discounted_price, c.duration, c.language, " +
                         "(SELECT COUNT(*) FROM enrollments e WHERE e.course_id = c.course_id) AS student_count " +
                         "FROM courses c " +
                         "WHERE c.instructor_id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, instructorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Courses course = new Courses();
                course.setCourse_id(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));
                course.setStudentCount(rs.getInt("student_count")); 
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

                
//                System.out.println("Raw courseID:"+course.getCourse_id());

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
        System.out.println("controller in repo");
        for(Courses cours : courses) {
        	System.out.println(cours);
        }
        return courses;
    }


    public Courses getCourseById(int id) {
        Courses course = null;

        String query = "SELECT * FROM courses WHERE course_id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                course = new Courses();
                course.setCourse_id(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));
                
                Categories categories = new Categories();
                categories.setCategory_id(rs.getInt("category_id"));
                course.setCategory_id(categories);
                
                Users instructor = new Users();
                instructor.setUser_id(rs.getInt("instructor_id"));
                course.setInstructor_id(instructor);
               
                course.setPrice(rs.getInt("price"));
                course.setDuration(rs.getInt("duration"));
                course.setCreated_at(rs.getTimestamp("created_at"));
            }

            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

       
        return course;
    }



        public boolean addCourses(Courses course) {
//        	boolean isAdded = false;
        	
        	String ADD_COURSE_SQL = "INSERT INTO courses " +
        	        "(title, description, instructor_id, category_id, price, discounted_price, duration, language, created_at, updated_at) " +
        	        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";


            try {
                Class.forName("org.postgresql.Driver");
                Connection conn = DriverManager.getConnection(URL, USER, PASS);

                PreparedStatement ps = conn.prepareStatement(ADD_COURSE_SQL, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, course.getTitle());
                ps.setString(2, course.getDescription());
                ps.setInt(3, course.getInstructor_id().getUser_id());
                ps.setInt(4, course.getCategory_id().getCategory_id());
                ps.setDouble(5, course.getPrice());
                ps.setDouble(6, course.getDiscounted_price());
                ps.setDouble(7, course.getDuration());
                List<String> languages = course.getLanguage(); 
                String languageStr = String.join(",", languages); 
                ps.setString(8, languageStr); 
                
                int rows = ps.executeUpdate();

                if (rows > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        int generatedId = rs.getInt(1);
                        course.setCourse_id(generatedId);
                    }
                    rs.close();
                }

                ps.close();
                conn.close();

                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

}
