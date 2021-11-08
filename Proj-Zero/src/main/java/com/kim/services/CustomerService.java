package com.kim.services;

import java.util.List;

import com.kim.exceptions.*;
import com.kim.models.*;
import com.kim.repositories.*;

public class CustomerService {
	
	private CustomerDAO custDao = new CustomerPostgreSQL();
	
	public CustomerService() {
		super();
		List<Customer> custs = custDao.getAllCustomers();
		for (Customer c : custs) {
			System.out.println(c);
		}
	}

	public void addCustomer(Customer newCust) {

		/*
		 * add business logic here to manipulate u before storage
		 * Employee, when registering are going to input 
		 * 		- user.name
		 * 		- user.username
		 * 		- user.password
		 * 
		 * System should assign 
		 * 	- credit_line - random whole to the hundreds money value between 200 and 1000
		 * 	- amount_due - 0.00
		 * 		
		 */
		
		
	}
	
	public Customer getCustomerById(int id) throws CustomerNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new CustomerNotFoundException();
		} 

		return null;
	}

}
