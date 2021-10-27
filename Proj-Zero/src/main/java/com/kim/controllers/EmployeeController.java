package com.kim.controllers;

import java.util.Scanner;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.services.*;

public class EmployeeController {

	private EmployeeService us = new EmployeeService();

	public void searchForEmployee() {
		// scanner getting user input
		try {
			Employee e = us.getEmployeeById(0);
		} catch (EmployeeNotFoundException e) {
			System.out.println("User doesn't exist.");
			e.printStackTrace();
		}
	}

	public void registerEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

}
