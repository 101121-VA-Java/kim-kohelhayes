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

		

		
	}
	
	public User getUserById(int id) throws UserNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new UserNotFoundException();
		} 

		return null;
	}



	public int register(User newUser, String roleChoice) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
