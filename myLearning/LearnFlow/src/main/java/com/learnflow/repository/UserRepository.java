package com.learnflow.repository;

import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.learnflow.enums.Role;
import com.learnflow.model.Users;

public class UserRepository {
	 private static final String URL = "jdbc:postgresql://localhost:5433/learnflow";
	    private static final String USER = "postgres";
	    private static final String PASS = "root";
	    
	    private static final String INSERT_USERS_SQL =
	    		"INSERT INTO users (username, email, password, firstname, lastname, registration_date, bio, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    private static final String FETCH_USER_SQL = "SELECT * FROM users WHERE email = ? AND password = ?";
	

	    public boolean saveUser(Users user) throws SQLException {
	        boolean rowInserted = false;

	        try {
	            Class.forName("org.postgresql.Driver");
	            Connection connection = DriverManager.getConnection(URL, USER, PASS);

	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());
	            preparedStatement.setString(4, user.getfirstname());
	            preparedStatement.setString(5, user.getlastname());
	            preparedStatement.setTimestamp(6, new Timestamp(user.getRegistration_date().getTime()));
	            preparedStatement.setString(7, user.getBio());
	            preparedStatement.setString(8, user.getRole().toString());

	            rowInserted = preparedStatement.executeUpdate() > 0;

	            preparedStatement.close();
	            connection.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return rowInserted;
	    }
	    
	    
	    public Users login(Users user) {
	        Users fetchUserD = null;

	        try {
	            Class.forName("org.postgresql.Driver");
	            Connection connection = DriverManager.getConnection(URL, USER, PASS);
	            PreparedStatement preparedStatement = connection.prepareStatement(FETCH_USER_SQL);
	            preparedStatement.setString(1, user.getEmail());
	            preparedStatement.setString(2, user.getPassword());

	            ResultSet rs = preparedStatement.executeQuery();

	            if (rs.next()) {
	                fetchUserD = new Users();
	                fetchUserD.setfirstname(rs.getString("firstname"));
	                fetchUserD.setlastname(rs.getString("lastname"));
	                fetchUserD.setUsername(rs.getString("username"));
	                fetchUserD.setEmail(rs.getString("email"));
	                fetchUserD.setBio(rs.getString("bio"));
	                

	                
	                try {
	                    fetchUserD.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
	                } catch (IllegalArgumentException e) {
	                    fetchUserD.setRole(Role.STUDENT);  
	                }
	                
	            }

	            rs.close();
	            preparedStatement.close();
	            connection.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return fetchUserD;
	    }
	    
	    public List<Users> getAllUsers() {
	        List<Users> users = new ArrayList<>();
	        try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	        try (Connection conn =  DriverManager.getConnection(URL, USER, PASS)) {
	            String sql = "SELECT * FROM users";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Users user = new Users();
	                user.setUser_id(rs.getInt("user_id"));
	                user.setEmail(rs.getString("email"));
	                user.setUsername(rs.getString("username"));
	                user.setRole(Role.valueOf(rs.getString("role")));

	                users.add(user);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return users;
	    }


}
