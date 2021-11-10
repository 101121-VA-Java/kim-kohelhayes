package com.kim.repositories;

import java.util.List;

import com.kim.models.User;

public interface UserDAO {
	
	List<User> getAllUsers();
	
	User getUser(User user);
	
	User getUserById(int id);

	int getUserId(User user); //returns User id
	
	int addUser(User user); // returns new User
	
	boolean editUser(User user); // returns bool

	boolean deleteUser(int userID); // returns true or false
	
	List<User> getOwedAmt(int usrId);
	
}
