package com.kim.services;


import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.repositories.*;

public class EmployeeService {

	private EmployeeDAO empDAO1;

	public EmployeeService() {
		super();
//		empDAO1 = new EmployeeArray();
	}

//	public int addEmployee(Employee emp) {
//
//		/*
//		 * add business logic here to manipulate e before storage Employee, when
//		 * registering are going to input - name - email - password
//		 * 
//		 * 
//		 * 
//		 */
//
//		emp.setName(null);

//		return empDAO1.addEmployee(emp);

//	}

//	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
//		Employee[] employees = { new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"),
//				new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin"),
//				new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager") };
		
//		for(int i = 0; i < employees.length; i++) {
//			if (id != employees[i].getId()) 
//			{
//				throw new EmployeeNotFoundException();
//			}else {
//				return employees[i];
//			}
//		}
//		return null;
//	}

}
