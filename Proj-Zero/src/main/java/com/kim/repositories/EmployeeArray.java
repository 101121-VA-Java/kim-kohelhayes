package com.kim.repositories;

import com.kim.models.Employee;

public class EmployeeArray implements EmployeeDAO {

	private Employee[] employees = { new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin") };

	public EmployeeArray() {
		super();
	}

	@Override
	public Employee[] getAllEmployees() {
		return this.employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
	
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
	public String editEmployeeById(int empID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editEmployeeByName(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(int empID) {
		// TODO Auto-generated method stub
		return null;
	}

}
