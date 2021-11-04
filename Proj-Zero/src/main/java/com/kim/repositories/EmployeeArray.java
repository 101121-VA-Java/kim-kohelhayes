package com.kim.repositories;

import org.apache.commons.lang3.ArrayUtils;

import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.models.Employee;

public class EmployeeArray implements EmployeeDAO {

	private Employee[] employees = { 
			new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"),
			new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin"),
			new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager") };

	public EmployeeArray() {
		super();
	}

	@Override
	public Employee[] getAllEmployees() {
		return this.employees;
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
		for (int i = 0; i < employees.length; i++) {
			if (id == employees[i].getId()) {
				return employees[i];
			}
		}
			throw new EmployeeNotFoundException();
	}

	@Override
	public int addEmployee(Employee employee) {

		// Create a tempArray of size employees + 1
		Employee[] tempArray = new Employee[employees.length + 1];
		int iterator = 0;
		for (; iterator < employees.length; iterator++) {
			tempArray[iterator] = employees[iterator];
		}
		/*
		 * iterator is the value of the last index of the new array
		 * (employees.length) set iterator to
		 * be the id for the new employee
		 */
		employee.setId(iterator);
		// adding the new employee to the array
		tempArray[iterator] = employee;
		/*
		 * assign the newly created array to employees
		 */
		employees = tempArray;
		System.out.println(employees);
		return iterator;
	}

	@Override
	public Employee editEmployeeByName(Employee emp) throws EmployeeNotFoundException {
		/*
		 * edit existing employee by: take in int for id and 
		 * changed name, changed email, changed password, 
		 * and/or changed manager change a field in the object
		 */

		for (int i = 0; i < employees.length; i++) {
			if (emp.getId() == employees[i].getId()) {
				// update this employee
				employees[i].setUsername(emp.getUsername());
				return employees[i];
			}

		}

		throw new EmployeeNotFoundException();
	}

	@Override
	public boolean deleteEmployeeById(int empID) {

		/*
		 * delete existing employee record by taking in int id do a for loop to find the
		 * id do a if statement
		 * 
		 * for(int i = 0; i< employees.length ; i++) { 
		 * if(empID == employees[i].getId()) {
		 * 
		 * delete record from db
		 * 
		 * return boolean true for deleted return boolean false for not deleted
		 * 
		 */
		return false;
	}

}
