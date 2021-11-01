package com.kim.controllers;

import java.util.Scanner;

public class LoginController {

	private Scanner scan;
	private EmployeeController ec;

	public LoginController() {
		scan = new Scanner(System.in);
		ec = new EmployeeController();
	}

	public void run() {
		boolean run = true;

		while (run) {
			System.out.println("Please select an option:");
			System.out.println("1: register");
			System.out.println("2: login");
			System.out.println("3: exit");

			String choice = scan.nextLine();

			switch (choice) {
			case "1":
				ec.registerEmployee(scan);
				// TODO: if an employee is not registered, display a different message: i.e. Employee Not Found Error
				break;
			case "2":
				// TODO: register employee
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
