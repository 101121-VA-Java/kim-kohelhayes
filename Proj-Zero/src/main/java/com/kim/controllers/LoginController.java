package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.UserNotFoundException;
import com.kim.models.User;
import com.kim.services.UserService;

public class LoginController {

	private UserService us = new UserService();
	User newUser;
	User currentUser;

	public void searchForUser() {
		// scanner getting user input
		try {
			User u = us.getUserById(0);
		} catch (UserNotFoundException u) {
			System.out.println("User doesn't exist.");
			u.printStackTrace();
		}
	}
//	TODO edit add employee not found exception here if not found	
//	
	
}
