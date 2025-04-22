package com.learnflow.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.learnflow.model.Categories;

public class CategoryRepository {
	
		private static final String URL = "jdbc:postgresql://localhost:5433/learnflow";
	    private static final String USER = "postgres";
	    private static final String PASS = "root";
	    
	
	    public List<Categories> getAllCategories() {
	        List<Categories> categoryList = new ArrayList<>();

	        String GET_ALL_CATEGORIES = "SELECT * FROM categories";

	        try {
	            Class.forName("org.postgresql.Driver");
	            Connection conn = DriverManager.getConnection(URL, USER, PASS);
	            PreparedStatement ps = conn.prepareStatement(GET_ALL_CATEGORIES);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Categories category = new Categories();
	                category.setCategory_id(rs.getInt("id"));
	                category.setName(rs.getString("name"));
	                category.setDescription(rs.getString("description"));

	                categoryList.add(category);
	            }

	            rs.close();
	            ps.close();
	            conn.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        System.out.println("category List");
	        System.out.println(categoryList);

	        return categoryList;
	    }
}
