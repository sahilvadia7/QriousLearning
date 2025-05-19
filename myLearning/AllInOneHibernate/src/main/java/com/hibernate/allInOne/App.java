package com.hibernate.allInOne;

import java.util.List;

import com.hibernate.allInOne.model.Address;
import com.hibernate.allInOne.model.Users;
import com.hibernate.allInOne.service.UserService;
import com.hibernate.allInOne.util.HibernateUtil;

public class App 
{
    	 public static void main(String[] args) {
    	        UserService userService = new UserService();

    	        // Create some users and addresses
    	        
//    	        Users user1 = new Users("john_doe", "password123", "john.doe@example.com");
//    	        Users user2 = new Users("jane_smith", "password456", "jane.smith@example.com");
//
//    	        Address address1 = new Address("123 Main St", "Anytown", user1);
//    	        Address address2 = new Address("456 Oak Ave", "Somecity", user1);
//    	        Address address3 = new Address("789 Pine Ln", "Othertown", user2);
//
//    	        user1.setAddresses(List.of(address1, address2));
//    	        user2.setAddresses(List.of(address3));
//
//    	        userService.createUsers(user1);
//    	        userService.createUsers(user2);


    	        // Get all users
    	        
//    	        System.out.println("\nAll Userss:");
//    	        List<Users> users = userService.getAllUsers();
//    	        for (Users user : users) {
//    	            System.out.println("ID: " + user.getId() + ", Usersname: " + user.getUsername() + ", Email: " + user.getEmail());
//    	            for(Address address : user.getAddresses()){
//    	                System.out.println("  Address: " + address.getStreet() + ", " + address.getCity());
//    	            }
//    	        }

    	        // Get a user by ID
//    	        System.out.println("\nUsers with ID 1:");
//    	        Users retrievedUsers = userService.getUsersById(1L);
//    	        if (retrievedUsers != null) {
//    	            System.out.println("Usersname: " + retrievedUsers.getUsername() + ", Email: " + retrievedUsers.getEmail());
//    	             for(Address address : retrievedUsers.getAddresses()){
//    	                System.out.println("  Address: " + address.getStreet() + ", " + address.getCity());
//    	            }
//    	        } else {
//    	            System.out.println("Users not found.");
//    	        }

    	        // Update a user
//    	        retrievedUsers.setEmail("john.doe.updated@example.com");
//    	        userService.updateUsers(retrievedUsers);
//    	        System.out.println("\nUpdated Users with ID 1:");
//    	        Users updatedUsers = userService.getUsersById(1L);
//    	        System.out.println("Updated Email: " + updatedUsers.getEmail());
//
//    	        // Delete a user
//    	        //userService.deleteUsers(2L);
//    	        System.out.println("\nUserss after deleting user with ID 2:");
//    	        List<Users> remainingUserss = userService.getAllUsers();
//    	        for (Users user : remainingUserss) {
//    	            System.out.println("Usersname: " + user.getUsername());
//    	        }

    	        // Example of using the join query
    	        
    	        System.out.println("\nUserss and their Addresses (Join Query):");
    	        List<Object[]> results = userService.getUserssWithAddresses();
    	        for (Object[] row : results) {
    	            System.out.println("Usersname: " + row[0] + ", Street: " + row[1] + ", City: " + row[2]);
    	        }

    	        HibernateUtil.shutdown();
    	    }
    	

    }

