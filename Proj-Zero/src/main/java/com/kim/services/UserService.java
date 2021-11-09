package com.kim.services;

import java.util.Scanner;

import com.kim.exceptions.UserFoundException;
import com.kim.models.User;
import com.kim.repositories.UserPostgreSQL;

public class UserService {

	private UserPostgreSQL ups = new UserPostgreSQL();

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

	public User getUserById(int i) {
		// TODO Auto-generated method stub
		return null;
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
