package com.kim.repositories;

import com.kim.models.Customer;
import java.util.ArrayList;
import com.kim.exceptions.CustomerNotFoundException;

public interface CustomerDAO {
	Customer[] getAllCustomers(); // returns an array of all of the Customers available

	Customer getCustomerById(int custID) throws CustomerNotFoundException; // returns a Customer object

	int addCustomer(Customer cust); // returns assigned id

	Customer editCustomerByName(Customer cust) throws CustomerNotFoundException; // returns String of Customer's information to look at

	boolean deleteCustomerById(int custID); // returns boolean
	
	double viewCustomerCreditLine(Customer cust); // takes in customer object returns double
	
	double viewCustomerAmountDue(Customer cust); // takes in customer object returns double
	
	double viewCustomerAmountAvailable(Customer cust); // takes in customer object returns double
	
	ArrayList viewItemsBought(Customer cust); // takes in customer object returns ArrayList
}
