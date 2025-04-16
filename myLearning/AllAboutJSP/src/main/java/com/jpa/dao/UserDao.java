package com.jpa.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.jpa.model.Users;
import com.jpa.model.Users.ROLE;

public class UserDao{

    private static final String URL = "jdbc:postgresql://localhost:5433/jdbc_users";
    private static final String USER = "postgres";
    private static final String PASS = "root";
    
    private static final String INSERT_USERS_SQL = 
        "INSERT INTO \"Users\" (username, email, password) VALUES (?, ?, ?)";
    
    private static final String FETCH_USER_SQL = "SELECT * FROM \"Users\" WHERE email = ? AND password = ?";
    static String username = "SahilVadia";
    static String email ="sahilvadia7776@gmail.com";
    private static final String UPDATE_USER_SQL = 
    	    "UPDATE \"Users\" SET username = ?, email = ? WHERE id = ?";


    private static final String DELETE_USER_SQL = "DELETE FROM  \"Users\" WHERE username =?";
    
    
   
    public boolean saveUser(Users user) throws SQLException {
        boolean rowInserted = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

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
                fetchUserD.setName(rs.getString("username"));
                fetchUserD.setEmail(rs.getString("email"));
                try {
                    fetchUserD.setRole(ROLE.valueOf(rs.getString("Role").toUpperCase()));
                } catch (IllegalArgumentException e) {
                    fetchUserD.setRole(ROLE.GUEST); 
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


    
    public boolean updateUser(Users user) {
        boolean updated = false;

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3,user.getId());
            
            updated = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }

    
    public boolean deleteUser(Users user) {
    	boolean deleted = false;
    	try {
    	Class.forName("org.postgresql.Driver");
    	Connection connection = DriverManager.getConnection(URL,USER,PASS);
    	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
        preparedStatement.setString(1, user.getName());
        
        deleted = preparedStatement.executeUpdate() >0;
        
        preparedStatement.close();
        connection.close();
        
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
        return deleted;

    }
    

    
}

