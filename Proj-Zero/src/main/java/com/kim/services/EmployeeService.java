package com.kim.services;


import java.util.List;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.repositories.*;

public class EmployeeService {

	private EmployeeDAO empDao = new EmployeePostgreSQL();
	
	public EmployeeService() {
		super();
		List<Employee> emps = empDao.getAllEmployees();
		for (Employee e : emps) {
			System.out.println(e);
		}
	}


	public void addEmployee(Employee newEmp) {

		/*
		 * add business logic here to manipulate u before storage
		 * Employee, when registering are going to input 
		 * 		- user.name
		 * 		- user.username
		 * 		- user.password
		 * 
		 * System should assign 
		 * 	-manager status - true/false
		 * 	-manager name - Admin
		 * 		
		 */
		
		
	}
	
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new EmployeeNotFoundException();
		} 

		return null;
	}

	
}
