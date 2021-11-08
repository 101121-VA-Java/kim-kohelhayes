package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.*;
import com.kim.repositories.*;
import com.kim.models.*;
import com.kim.services.*;

public class RegisterController {

	private UserService us = new UserService();
	UserDAO ud = new UserPostgreSQL();
	private User currentUser;
	

	public void registerUser(Scanner scan) {

		try {
			System.out.println("Please enter your name: ");
			String name = scan.nextLine();
			System.out.println("Please enter a username:");
			String username = scan.nextLine();
			System.out.println("Please enter a password:");
			String password = scan.nextLine();

			try {
				User newUser = new User(name, username, password);
				User possibleUser = new User(name, username, password);
				ud.getUserId(possibleUser);

				try {
					String posChoice = scan.nextLine();
					int newUserId = us.register(newUser, posChoice);
					System.out.println("Registration successful.");
					System.out.println("Logged in as " + newUser.getUsername() + ".");
					this.currentUser = newUser;
					this.currentUser.setId(newUserId);
				} catch (InvalidPosition e3) {
					System.out.println("User must be 1: CUSTOMER or 2: EMPLOYEE");
					System.out.println("TRY AGAIN!!");
				}
			} catch (UserFoundException e2) {
				System.out.println("User Already Exists!");
				System.out.println("Proceed to LogIn Menu!");
			}
		} catch (Exception e1) {
			System.out.println("Name, Username or Password is Too Long!");
			System.out.println("TRY AGAIN!!");
		}

	}

//		TODO edit add employee not found exception here if not found	
//		
//		 TODO: check whether an employee created or not (if the method works)
//		us.addUser(newUser);
//		
//		System.out.println("Employee has been registered");

}
