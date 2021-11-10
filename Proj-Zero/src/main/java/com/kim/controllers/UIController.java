package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.UserFoundException;
import com.kim.exceptions.UserNotFoundException;

public class UIController {
	
	private Scanner scan;
	private RegisterController rc;
	private LoginController lc;
	
	public UIController() {
		scan = new Scanner(System.in);
		rc = new RegisterController();
		lc = new LoginController();
		}
	

	public void main() {
		boolean main = true;
		
		while(main) {
			System.out.println("Please select an option:");
			System.out.println("1: New Users Register Here");
			System.out.println("2: Login Here");
			System.out.println("3: exit");
			
			String choice = scan.nextLine();
			
			switch(choice) {
			case "1":
				try {
					rc.registerUser(scan);
				} catch (UserFoundException e) {
					System.out.println("User Already Exists!");
					System.out.println("Proceed to LogIn Menu!");
					e.printStackTrace();
				}
				break;
			case "2":
				try {
					lc.tryLogin(scan);
				} catch (UserNotFoundException e1) {
					System.out.println("User Does Not Exist!");
					System.out.println("Go Back to Register Menu!");
					e1.printStackTrace();
				}
				break;	
			case "3":
				main = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		scan.close();
	
	}
}
