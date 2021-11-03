package com.kim.repositories;

import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.models.Employee;

public interface EmployeeDAO {
	Employee[] getAllEmployees(); // returns an array of all of the employees available
	
	Employee getEmployeeById(int empID) throws EmployeeNotFoundException; // returns Employee Object

	int addEmployee(Employee emp); // returns assigned id

	Employee editEmployeeByName(Employee emp) throws EmployeeNotFoundException; // returns Employee Object

	boolean deleteEmployeeById(int empID); // returns true or false
}
