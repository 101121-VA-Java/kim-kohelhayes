package com.kim.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.models.Employee;
import com.kim.repositories.EmployeeArray;
import com.kim.repositories.EmployeeDAO;

public class EmployeeDAOTest {

	private EmployeeDAO emp = new EmployeeArray();

	@BeforeEach
	public void setup() {
		emp = new EmployeeArray();
	}

	@Test
	public void getAllEmployees() {
		
		Employee[] expected = { 
				new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"),
				new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin"),
				new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager") };

		Employee[] actual = emp.getAllEmployees();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void employeeNotFoundById() throws EmployeeNotFoundException {

		assertThrows(EmployeeNotFoundException.class, () -> emp.getEmployeeById(3),
				"Expected getEmployeeById(3) to throw, but it didn't");

	}

	@Test
	public void getEmployeeById() throws EmployeeNotFoundException {

		Employee expected = new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager");
		int id = 2;
		Employee actual = emp.getEmployeeById(id);
		assertEquals(expected, actual);

	}

	@Test
	public void addEmployeeValid() {
		Employee[] expected = { 
				new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"),
				new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin"),
				new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager"),
				new Employee(3, "Brad", "brad@123.com", "pass", false, "Manager") };

		// Adding an employee
		emp.addEmployee(new Employee(3, "Brad", "brad@123.com", "pass", false, "Manager"));

		assertArrayEquals(expected, emp.getAllEmployees());
	}

	@Test
	public void employeeNotFoundByName() throws EmployeeNotFoundException {

		Employee brad = new Employee(3, "Brad", "brad@123.com", "pass", false, "Manager");

		assertThrows(EmployeeNotFoundException.class, () -> emp.editEmployeeByName(brad),
				"Expected getEmployeeByName(3) to throw, but it didn't");

	}

	@Test
	public void editEmployeeByName() throws EmployeeNotFoundException {

		Employee expected = new Employee(2, "Kim", "Kim@123.com", "pass", false, "Manager");
		Employee kim = new Employee(2, "Kim", "Kim@123.com", "pass", false, "Manager");
		Employee actual = emp.editEmployeeByName(kim);
		assertEquals(expected, actual);

	}

	@Test
	public void deleteEmployeeById() {

		boolean expected = true;
		int id = 2;
		boolean actual = emp.deleteEmployeeById(id);
		assertEquals(expected, actual);
	}

}
