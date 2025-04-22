package com.learnflow.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.learnflow.model.Users;
import com.learnflow.repository.UserRepository;

public class UserService{
	
	private UserRepository userRepo = new UserRepository();
	
	public Users registerUser(Users user) throws SQLException {
		if(userRepo.saveUser(user)) {
			return user;
		}
		return null;
	}
	
	public Users loginUser(Users user) throws SQLException{
		Users userFound = userRepo.login(user);
		if(userFound != null) {
			return userFound;
		}
		return null;
	}

	public List<Users> getAllUserS() {
		List<Users> allUsers = userRepo.getAllUsers();
		return allUsers;
	}
	
	public boolean deleteUserById(Integer UserId,HttpSession session) {
		if(UserId!=null) {
			return userRepo.deleteUserById(UserId,session);
		}
		return false;
	}
	


}
