package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.UserFoundException;

public class UIController {
	
	private Scanner scan;
	private RegisterController rc;
	
	public UIController() {
		scan = new Scanner(System.in);
		rc = new RegisterController();	
		}
	

	public void run() {
		boolean run = true;
		
		while(run) {
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
				// TODO: if a user is not registered, display a different message
				break;
			case "2":
				break;	
			case "3":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		scan.close();
	
	}
}

//
//System.out.println("Please select an option:");
//System.out.println("1: Customers Register Here");
//System.out.println("2: Customers Login Here");
//System.out.println("3: Employees Register Here");
//System.out.println("4: Employees Login Here");
//System.out.println("3: exit");
