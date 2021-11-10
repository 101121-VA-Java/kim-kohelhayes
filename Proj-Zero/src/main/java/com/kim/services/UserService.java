package com.kim.services;

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

	public boolean register(User usr) {
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

	public int checkUser(User usr) throws UserNotFoundException {
		User user = ups.getUser(usr);
		
		int id = -1;
		id = ups.getUserId(user);
		if (id < 0) {
			LogUtil.descriptiveError("User Does Not Exist");
			throw new UserNotFoundException();	
		}else {
			System.out.println("Login Successful!");
		}
		return id;
	}	

	public User getUser(int curId) {
		User currentUser = ups.getUserById(curId);
		return currentUser;
	}

	public User userMenu(User currentUser) {
		if(currentUser.getPosition() == "CUSTOMER") {
			uc.customerMenu(currentUser, null);
		}else {
			uc.employeeMenu(currentUser, null);
		}
		return currentUser;
	}


}
