package com.kim.repositories;

import java.util.List;

import com.kim.models.User;

public interface UserDAO {
	
	List<User> getAllUsers();

	int getUserId(User user); //returns User id
	
	int addUser(User user); // returns new User
	
	boolean editUser(User user); // returns bool

	boolean deleteUser(int userID); // returns true or false
	
	User getUserFromId(int curId);
}
