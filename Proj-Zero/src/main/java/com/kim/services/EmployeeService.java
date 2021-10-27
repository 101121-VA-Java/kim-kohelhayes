package com.kim.services;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.repositories.*;

public class EmployeeService {

	private EmployeeDAOAble empDAO1;

	public EmployeeService() {
		super();
		empDAO1 = new EmployeeArray();
	}

	public int addEmployee(Employee emp) {

		/*
		 * add business logic here to manipulate e before storage Employee, when
		 * registering are going to input - name - email - password
		 * 
		 * System should assign, Role, manager - manager is null by default (default
		 * value of an object is null)
		 * 
		 */

		emp.setName(null);

		return empDAO1.addEmployee(emp);

	}

	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		if (id > 0) // What do I put here
		{
			throw new EmployeeNotFoundException();
		}
		return null;
	}

}
