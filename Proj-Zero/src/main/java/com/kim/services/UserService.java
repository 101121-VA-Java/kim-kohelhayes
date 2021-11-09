package com.kim.services;

import java.util.Scanner;

import com.kim.controllers.UserController;
import com.kim.exceptions.UserFoundException;
import com.kim.exceptions.UserNotFoundException;
import com.kim.models.User;
import com.kim.repositories.UserPostgreSQL;
import com.kim.util.LogUtil;

public class UserService {

	private UserPostgreSQL ups = new UserPostgreSQL();
	private UserController uc = new UserController();

	public UserService(UserPostgreSQL ups) {
		super();
		this.ups = ups;
	}

	public void registerUser(User usr) throws UserFoundException {

		if (usr.getId() != ups.getUserId(usr)) {
			throw new UserFoundException();
		}
	}

	public boolean register(User usr, int posChoice) {
		if (posChoice == 1) usr.setPosition("CUSTOMER");
		else usr.setPosition("EMPLOYEE");
		int nwUsrId = -1;
		try{
			nwUsrId = ups.addUser(usr);
            if(nwUsrId == -1) throw new Exception();
        } catch(Exception e){
            LogUtil.descriptiveError("Registration failed for some reason. ");
            return false;
        }
        return true;
	}

	public void tryLogin(User usr) throws UserNotFoundException {
		int id = -1;
		id = ups.getUserId(usr);
		if (id < 0) {
			LogUtil.descriptiveError("User Does Not Exist");
			throw new UserNotFoundException();	
		}
	}	
	
	public int login(User usr) {
		System.out.println("Login Successful!");
		
		int id = ups.getUserId(usr);
		return id;
	}

	public User getUser(int curId) {
		User currentUser = ups.getUserFromId(curId);
		return currentUser;
	}

	public void userMenu(User currentUser) {
		if(currentUser.getPosition() == "CUSTOMER") {
			uc.customerMenu(currentUser);
		}else {
			uc.employeeMenu(currentUser);
		}
		
	}

//  public User login(String username, String password) throws UserNotFoundException{
//  try {
//      for (User user : up.getAll()) {
//          if(user.getUsername().equals(username) && user.getPassword().equals(password)){
//              return user;
//          }
//      }
//      throw new UserNotFoundException();
//  } catch (UserNotFoundException e) {
//      LogUtil.descriptiveError("User Not Found");
//  }
//  return null;
//}

}
