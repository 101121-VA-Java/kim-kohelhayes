package com.kim.repositories;

import com.kim.models.Employee;

public interface EmployeeDAO {
	Employee[] getAllEmployees(); // returns an array of all of the employees available

	Employee getEmployeeById(int empID); // returns Employee Object

	int addEmployee(Employee emp); // returns assigned id

	Employee editEmployeeByName(Employee emp); // returns Employee Object

	String deleteEmployeeById(int empID); // returns String "Successful" or "Unsuccessful"
}
