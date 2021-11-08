package com.kim.services;


import java.util.List;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.repositories.*;

public class UserService {

	private UserDAO usrDao = new UserPostgreSQL();
	
	public UserService() {
		super();
		List<User> usrs = usrDao.getAllUsers();
		for (User u : usrs) {
			System.out.println(u);
		}
	}

	

	public void addUser(User newUser) {

		/*
		 * add business logic here to manipulate u before storage
		 * User, when registering are going to input 
		 * 		- name
		 * 		- Username
		 * 		- password
		 * 
		 * System should assign id
		 * 		
		 * 		
		 */
		
		
	}
	
	public User getUserById(int id) throws UserNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new UserNotFoundException();
		} 

		return null;
	}

	

}
