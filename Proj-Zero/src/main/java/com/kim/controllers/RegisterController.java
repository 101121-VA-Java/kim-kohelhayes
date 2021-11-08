package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.*;
import com.kim.repositories.*;
import com.kim.models.*;
import com.kim.services.*;

public class RegisterController {

	private UserService us = new UserService();
	UserDAO ud = new UserPostgreSQL();
	
	
	


	public void registerUser(Scanner scan){
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		
//		try {
//			User possibleUser = new User(name, username, password);
//			ud.getUserId(possibleUser);
//		 	}
//		 }
//		
//		
//		String posChoice = scan.nextLine();
//	    int newUserId = us.register(newUser, posChoice);
//		System.out.println("Registration successful.");
//		System.out.println("Logged in as " + newUser.getUsername() + ".");
//		this.currentUser = newUser;
//		this.currentUser.setId(newUserId);
//	
//		
//		
//		
//		// TODO: check whether an employee created or not (if the method works)
//		us.addUser(newUser);
//		
//		System.out.println("Employee has been registered");
		
	}
	
	
	
//	TODO edit add employee not found exception here if not found

}


//
//public void attemptRegistration(Scanner scan) {
//    System.out.println("Please enter a username:");
//    String username = scan.nextLine();
//    System.out.println("Please enter a password:");
//    String password = scan.nextLine();
//    User newUser = new User(username, password);
//    System.out.println("Please choose a role. 1 for customer, 2 for employee.");
//    String roleChoice = scan.nextLine();
//    try {
//        int newUserId = us.register(newUser, roleChoice);
//        System.out.println("Registration successful.");
//        System.out.println("Logged in as " + newUser.getUsername() + ".");
//        this.currentUser = newUser;
//        this.currentUser.setId(newUserId);
//    } catch (InvalidRole e) {
//        System.out.println("Please choose a valid role next time. 1 for customer, 2 for employee.");
//    }
//}
