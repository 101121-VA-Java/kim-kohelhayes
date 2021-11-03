package com.kim.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kim.exceptions.CustomerNotFoundException;
import com.kim.models.Customer;
import com.kim.repositories.CustomerArray;
import com.kim.repositories.CustomerDAO;

public class CustomerDAOTest {

	private CustomerDAO cust = new CustomerArray();

	@BeforeEach
	public void setup() {
		cust = new CustomerArray();
	}

	@Test
	public void getAllCustomers() {
		
		Customer[] expected = { 
				new Customer(0, "Rhonda", "rhon@123.com", "pass", 500.00, 225.00, 275.00),
				new Customer(1, "Edward", "ed@123.com", "pass", 400.00, 300.00, 100.00),
				new Customer(2, "Scott", "scott@123.com", "pass", 600.00, 300.00, 300.00) };

		Customer[] actual = cust.getAllCustomers();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void customerNotFoundById() throws CustomerNotFoundException {

		assertThrows(CustomerNotFoundException.class, () -> cust.getCustomerById(3),
				"Expected getCustomerById(3) to throw, but it didn't");

	}

	@Test
	public void getCustomerById() throws CustomerNotFoundException {

		Customer expected = new Customer(2, "Scott", "scott@123.com", "pass", 600.00, 300.00, 300.00);
		int id = 2;
		Customer actual = cust.getCustomerById(id);
		assertEquals(expected, actual);

	}

	@Test
	public void addCustomerValid() {
		Customer[] expected = { 
				new Customer(0, "Rhonda", "rhon@123.com", "pass", 500.00, 225.00, 275.00),
				new Customer(1, "Edward", "ed@123.com", "pass", 400.00, 300.00, 100.00),
				new Customer(2, "Scott", "scott@123.com", "pass", 600.00, 300.00, 300.00), 
				new Customer(3, "Della", "del@123.com", "pass", 450.00, 150.00, 300.00)};

		// Adding an employee
		cust.addCustomer(new Customer(3, "Della", "del@123.com", "pass", 450.00, 150.00, 300.00));
//				

		assertArrayEquals(expected, cust.getAllCustomers());
	}

	@Test
	public void customerNotFoundByName() throws CustomerNotFoundException {

		Customer del = new Customer(3, "Della", "del@123.com", "pass", 450.00, 150.00, 300.00);

		assertThrows(CustomerNotFoundException.class, () -> cust.editCustomerByName(del),
				"Expected getCustomerByName(3) to throw, but it didn't");

	}

	@Test
	public void editCustomerByName() throws CustomerNotFoundException {

		Customer expected = new Customer(2, "Scotter", "scott@123.com", "pass", 600.00, 300.00, 300.00);
		Customer scott = new Customer(2, "Scotter", "scott@123.com", "pass", 600.00, 300.00, 300.00);
		Customer actual = cust.editCustomerByName(scott);
		assertEquals(expected, actual);

	}

	@Test
	public void deleteCustomerById() {

		boolean expected = true;
		int id = 2;
		boolean actual = cust.deleteCustomerById(id);
		assertEquals(expected, actual);
	}

}