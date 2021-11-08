package com.kim.controllers;

import java.util.Scanner;

public class UIController {
	
	private Scanner scan;
	private UserController uc;
	
	public UIController() {
		scan = new Scanner(System.in);
		uc = new UserController();	
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
				uc.registerUser(scan);
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
