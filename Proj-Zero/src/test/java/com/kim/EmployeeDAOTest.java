package com.kim;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kim.models.Employee;
import com.kim.repositories.EmployeeArray;
import com.kim.repositories.EmployeeDAO;


public class EmployeeDAOTest {


	private EmployeeDAO ed;
	
	@BeforeEach
	public void setup() {
		ed = new EmployeeArray();
		
	}
	
	@Test
	public void getAllEmployees(){
		Employee[] expected = {	new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin")}; 
								
		Employee[] actual = ed.getAllEmployees();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void addEmployeeValid() {
		Employee[] expected = {new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin"), 
								new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin") };
		
		// Adding an employee
		ed.addEmployee(new Employee(1, "Manager", "mngr@123.com", "pass", true, "TheAdmin"));
//				ed.addEmployee(new Employee(2, "Kim", "kim@123.com", "pass", false, "Manager"));
		
		assertArrayEquals(expected, ed.getAllEmployees());
	}	
	
	
	@Test
	public void getEmployeeById() {
		
		Employee expected = new Employee(0, "TheAdmin", "admin@123.com", "pass", true, "TheAdmin");
		
		Employee actual = ed.getEmployeeById(0);
		assertEquals(expected, actual);
		
	}
	
	
	
	
	
	
}
