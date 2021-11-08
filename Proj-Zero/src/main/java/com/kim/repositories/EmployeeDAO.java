package com.kim.repositories;

import java.util.List;

import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.models.Employee;
import com.kim.models.User;

public interface EmployeeDAO {
	List<Employee> getAllEmployees(); // returns a list of all of the employees available

	Employee getEmployeeById(int empID); // returns Employee Object
	
	int addEmployee(Employee emp); // returns new employee id

	boolean editEmployee(Employee emp); // returns bool

	boolean deleteEmployee(int empID); // returns true or false
}
