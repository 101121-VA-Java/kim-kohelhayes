package com.kim.repositories;

import com.kim.models.Customer;
import java.util.List;

import com.kim.exceptions.CustomerNotFoundException;

public interface CustomerDAO {
	List<Customer> getAllCustomers(); // returns an array of all of the Customers available

	Customer getCustomerById(int custID) throws CustomerNotFoundException; // returns a Customer object

	boolean addCustomer(Customer cust); // returns assigned id

	boolean editCustomer(Customer cust) throws CustomerNotFoundException; // returns String of Customer's information to look at

	boolean deleteCustomerById(int custID); // returns boolean
	
	double viewCustomerCreditLine(int custID); // takes in customer object returns double
	
	double viewCustomerDue(int custID); // takes in customer object returns double
	
	//ArrayList viewItemsBought(Customer cust); // takes in customer object returns ArrayList
}
