package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.services.*;

public class EmployeeController {

	private EmployeeService es = new EmployeeService();

	public void searchForEmployee() {
		// scanner getting user input
		try {
			Employee e = es.getEmployeeById(0);
		} catch (EmployeeNotFoundException e) {
			System.out.println("Employee doesn't exist.");
			e.printStackTrace();
		}
	}

	public void registerEmployee(Scanner scan) {
		System.out.println("Please enter a username:");
		String username = scan.nextLine();
		System.out.println("Please enter a password:");
		String password = scan.nextLine();
		System.out.println("Please enter your name: ");
		String name = scan.nextLine();
		
		Employee newEmployee = new Employee(0, name, username, password, 0, false, name);
		
		// TODO: check whether an employee created or not (if the method works)
		es.addEmployee(newEmployee);
		
		System.out.println("Employee has been registered");
		
	}
	
	
	
//	TODO edit add employee not found exception here if not found

}




