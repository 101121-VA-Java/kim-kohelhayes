package com.kim.repositories;

import com.kim.models.Customer;
import com.kim.models.Item;

import java.util.List;

import com.kim.exceptions.CustomerNotFoundException;

public interface CustomerDAO {
	List<Customer> getAllCustomers(); // returns an array of all of the Customers available

	Customer getCustomerById(int custID); // returns a Customer object

	boolean addCustomer(Customer cust); // returns assigned id

	boolean editCustomer(Customer cust); // returns String of Customer's information to look at

	boolean deleteCustomer(int custID); // returns boolean

	double viewCustomerCreditLine(int custID); // takes in customer object returns double

	double viewCustomerDue(int custID); // takes in customer object returns double

	List<Item> viewItemsBought(int custID); // takes in customer object returns ArrayList
}
