package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.*;
import com.kim.repositories.*;
import com.kim.models.*;
import com.kim.services.UserService;

public class RegisterController {

	private UserPostgreSQL ups = new UserPostgreSQL();
	private UserService us = new UserService(null);
	UserDAO ud = new UserPostgreSQL();

	public void registerUser(Scanner scan) throws UserFoundException {

		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
			if(name.length() > 30 ) {
				System.out.println("Name is too long! Try Again!");
				name = scan.nextLine();
			}
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
			if(username.length() > 20 ) {
				System.out.println("Name is too long! Try Again!");
				username = scan.nextLine();
			}
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
			if(password.length() > 15 ) {
				System.out.println("Name is too long! Try Again!");
				password = scan.nextLine();
			}
		System.out.println("Enter 1: CUSTOMER or 2: EMPLOYEE");	
		int posChoice = scan.nextInt();
			if( posChoice != 1 | posChoice != 2 ) {
				System.out.println("Enter 1: CUSTOMER or 2: EMPLOYEE");	
				posChoice = scan.nextInt();
			}
			
			
		User potentialUser = new User(name, username, password);
		
		
		
		if (potentialUser.getId() != ups.getUserId(potentialUser)) {

			throw new UserFoundException();
		}
		
		us.register(potentialUser,posChoice);
	}
	

}



