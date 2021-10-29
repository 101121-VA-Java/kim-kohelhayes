package com.kim.repositories;

import com.kim.models.User;
import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.models.Employee;

public class EmployeeArray implements EmployeeDAO {

	private Employee[] employees = { new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"),
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
	public Employee getEmployeeById(int id) throws EmployeeNotFoundException  {
		

		for (int i = 0; i < employees.length; i++) {
			if (id == employees[i].getId()) {
				return employees[i];
			}else {
				throw new EmployeeNotFoundException(); 
			}

		}
		return employees[id];
		
	}

	@Override
	public int addEmployee(Employee e) {

		// Create a temp array of size employees + 1
		Employee[] temp = new Employee[employees.length + 1];

		int i = 0;

		for (; i < employees.length; i++) {
			temp[i] = employees[i];
		}
		/*
		 * i is the value of the last index of the new array (employees.length) set i to
		 * be the id for the new employee
		 */
		e.setId(i);

		// adding the new employee to the array
		temp[i] = e;

		/*
		 * assign the newly created array to employees
		 */
		employees = temp;
		System.out.println(employees);
		return i;
	}

	@Override
	public Employee editEmployeeByName(Employee emp) {
		/*
		 * edit existing employee by: take in int for id and changed name, changed
		 * email, changed password, and/or changed manager change a field in the object
		 */

		for (int i = 0; i < employees.length; i++) {
			if (emp.getId() == employees[i].getId()) {
				// update this employee
				employees[i].setEmail(emp.getEmail());
				return employees[i];
			}

		}

		return null;// this catches when no one is found
	}

	@Override
	public boolean deleteEmployeeById(int empID) {

		/*
		 * delete existing employee record by taking in int id do a for loop to find the
		 * id do a if statement
		 * 
		 * for(int i = 0; i< employees.length ; i++) { if(emp.getId() ==
		 * employees[i].getId()) {
		 * 
		 * delete record from db
		 * 
		 * return boolean true for deleted return boolean false for not deleted
		 * 
		 */

		return null;
	}


}
