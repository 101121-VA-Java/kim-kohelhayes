package com.kim.repositories;

import java.util.List;

import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.models.Employee;

public interface EmployeeDAO {
	List<Employee> getAllEmployees(); // returns a list of all of the employees available
	
	Employee getEmployeeById(int empID) throws EmployeeNotFoundException; // returns Employee Object

	boolean addEmployee(Employee emp); // returns assigned id

	boolean editEmployee(Employee emp) throws EmployeeNotFoundException; // returns Employee Object

	boolean deleteEmployee(int empID); // returns true or false
}
