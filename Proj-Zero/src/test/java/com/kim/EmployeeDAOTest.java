package com.kim;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		Employee[] expected = { new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin") };

		Employee[] actual = emp.getAllEmployees();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void getEmployeeById() {

		Employee expected = new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin");

		Employee actual = emp.getEmployeeById(0);
		assertEquals(expected, actual);

	}

	@Test
	public void addEmployeeValid() {
		Employee[] expected = { new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"),
				new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin") };

		// Adding an employee
		emp.addEmployee(new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin"));
//				ed.addEmployee(new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager"));

		assertArrayEquals(expected, emp.getAllEmployees());
	}

	@Test
	public void editEmployeeByName() {

		Employee expected = new Employee(0, "TheAdmin", "Admin@123.com", "pass", true, "TheAdmin");

		Employee actual = emp.editEmployeeByName(expected);
		assertEquals(expected, actual);

	}

}
