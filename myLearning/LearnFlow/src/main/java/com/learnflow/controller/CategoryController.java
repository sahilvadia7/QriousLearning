package com.learnflow.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnflow.model.Categories;
import com.learnflow.repository.CategoryRepository;

public class CategoryController{
	
	private CategoryRepository categoryRepo = new CategoryRepository();

	public List<Categories> getAllCategories(){
		return categoryRepo.getAllCategories();
	}

}
