package com.hibernate.allInOne.service;


import java.util.List;

import com.hibernate.allInOne.Dao.UserDao;
import com.hibernate.allInOne.model.Users;

public class UserService {

    private UserDao userDAO = new UserDao();

    public void createUsers(Users user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
           throw new IllegalArgumentException("Usersname cannot be null or empty");
        }
        userDAO.saveUser(user);
    }

    public Users getUsersById(Long id) {
        // Add business logic here
        return userDAO.getUserById(id);
    }

    public List<Users> getAllUsers() {
         return userDAO.getAllUsers();
    }

      public void updateUsers(Users user) {
        //  Add business logic
        userDAO.updateUser(user);
    }

    public void deleteUsers(Long id) {
        userDAO.deleteUser(id);
    }

     public List<Object[]> getUserssWithAddresses() {
        return userDAO.getUsersWithAddresses();
    }
}