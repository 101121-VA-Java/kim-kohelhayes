package com.kim.controllers;

import java.util.Scanner;
import com.kim.models.User;
import com.kim.services.UserService;
import com.kim.repositories.UserDAO;
import com.kim.repositories.UserPostgreSQL;

public class LoginController {

	private UserService us = new UserService(null);
	
	UserDAO ud = new UserPostgreSQL();
	User currentUser;

	public void tryLogin(Scanner scan) {
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Please enter your password:");
		String password = scan.nextLine();
		User usr = new User(username, password);
		int curId = us.login(usr);
		currentUser = us.getUser(curId);
		us.userMenu(currentUser);
	}	
	
}
