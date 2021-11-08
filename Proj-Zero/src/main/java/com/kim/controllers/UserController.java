package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.services.*;

public class UserController {

	private UserService us = new UserService();

	public void searchForUser() {
		// scanner getting user input
		
		try {
			User u = us.getUserById(0);
		} catch (UserNotFoundException u) {
			System.out.println("User doesn't exist.");
			u.printStackTrace();
		}
	}

	public void registerUser(Scanner scan) {
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		
		
		User newUser = new User(name, username, password);
		
		// TODO: check whether an User created or not (if the method works)
		us.addUser(newUser);
		
		System.out.println("User has been registered");
		
	}
	
	
	
//	TODO edit add User not found exception here if not found

}




