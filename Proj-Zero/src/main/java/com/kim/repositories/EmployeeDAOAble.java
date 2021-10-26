package com.kim.repositories;

import com.kim.models.Employee;

public interface EmployeeDAOAble {
	Employee[] getAllEmployees(); // returns an array of all of the employees available
	Employee getEmployeeById(int empID);
	int addEmployee(Employee emp); // returns assigned id
	String editEmployeeById(int empID);  //returns String of employee's information to look at 
	String editEmployeeByName(Employee emp);  //returns String of employee's information to look at 
	String deleteEmployeeById(int empID);  //returns String "Successful" or "Unsuccessful" depending on operation success 
}
