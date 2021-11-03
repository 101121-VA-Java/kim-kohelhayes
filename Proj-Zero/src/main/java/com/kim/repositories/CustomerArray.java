package com.kim.repositories;

import java.util.ArrayList;
import com.kim.exceptions.CustomerNotFoundException;
import com.kim.models.Customer;

public class CustomerArray implements CustomerDAO {
	
	private Customer[] customers = { 
			new Customer(0, "Rhonda", "rhon@123.com", "pass", 500.00, 225.00, 275.00),
			new Customer(1, "Edward", "ed@123.com", "pass", 400.00, 300.00, 100.00),
			new Customer(2, "Scott", "scott@123.com", "pass", 600.00, 300.00, 300.00) };
	
	public CustomerArray() {
		super();
	}

	@Override
	public Customer[] getAllCustomers() {
		return this.customers;
	}

	@Override
	public Customer getCustomerById(int custID) throws CustomerNotFoundException {
		for (int i = 0; i < customers.length; i++) {
			if (custID == customers[i].getId()) {
				return customers[i];
			}
		}
			throw new CustomerNotFoundException();
	}

	@Override
	public int addCustomer(Customer cust) {
		// Create a tempArray of size customers + 1
		Customer[] tempArray = new Customer[customers.length + 1];
		int iterator = 0;
		for (; iterator < customers.length; iterator++) {
			tempArray[iterator] = customers[iterator];
		}
		/*
		 * iterator is the value of the last index of the new array
		 * (customers.length) set iterator to be the id for the new customer
		 */
		cust.setId(iterator);
		// adding the new customer to the array
		tempArray[iterator] = cust;
		// assign the newly created array to customers
		customers = tempArray;
		return iterator;
	}

	
	@Override
	public Customer editCustomerByName(Customer cust) throws CustomerNotFoundException  {
		/*
		 * edit existing customer by: take in int for id and 
		 * changed name, changed email, changed password, 
		 * and/or money fields
		 */

		for (int i = 0; i < customers.length; i++) {
			if (cust.getId() == customers[i].getId()) {
				// update this customer
				customers[i].setName(cust.getName());
				return customers[i];
			}

		}

		throw new CustomerNotFoundException();
	}

	@Override
	public boolean deleteCustomerById(int custID) {
		/*
		 * delete existing customer record by taking in int id do a for loop to find the
		 * id do a if statement
		 * 
		 * for(int i = 0; i< customers.length ; i++) { 
		 * if(custID == customers[i].getId()) {
		 * 
		 * delete record from db
		 * 
		 * return boolean true for deleted return boolean false for not deleted
		 * 
		 */
		return false;
	}

	@Override
	public double viewCustomerCreditLine(Customer cust) {
		/*
		 *  TODO Auto-generated method stub
		 */
		return 0;
	}

	@Override
	public double viewCustomerAmountDue(Customer cust) {
		/*
		 *  TODO Auto-generated method stub
		 */
		return 0;
	}

	@Override
	public double viewCustomerAmountAvailable(Customer cust) {
		/*
		 *  TODO Auto-generated method stub
		 */
		return 0;
	}

	@Override
	public ArrayList viewItemsBought(Customer cust) {
		/*
		 *  TODO Auto-generated method stub
		 */
		return null;
	}

}
