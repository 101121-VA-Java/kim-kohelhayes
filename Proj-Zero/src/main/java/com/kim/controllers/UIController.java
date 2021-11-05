package com.kim.controllers;

import java.util.Scanner;

public class UIController {
	
	private Scanner scan;
	private EmployeeController ec;
	private CustomerController cc;
	
	public UIController() {
		scan = new Scanner(System.in);
		ec = new EmployeeController();
		cc = new CustomerController();
	}
	

	public void run() {
		boolean run = true;
		
		while(run) {
			System.out.println("Please select an option:");
			System.out.println("1: Customers Register Here");
			System.out.println("2: Customers Login Here");
			System.out.println("3: Employees Register Here");
			System.out.println("4: Employees Login Here");
			System.out.println("3: exit");
			
			String choice = scan.nextLine();
			
			switch(choice) {
			case "1":
				cc.registerCustomer(scan);
				// TODO: if a customer is not registered, display a different message
				break;
			case "2":
				break;
			case "3":
				ec.registerEmployee(scan);
				// TODO: if an employee is not registered, display a different message	
			case "4":
				break;	
			case "5":
				run = false;
				break;
			default:
				System.out.println("Invalid input.");
			}
		}
		
		scan.close();
	
	}
}
