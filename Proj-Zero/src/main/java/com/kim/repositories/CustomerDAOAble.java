package com.kim.repositories;

import com.kim.models.Customer;

public interface CustomerDAOAble {
	Customer[] getAllCustomers(); // returns an array of all of the employees available

	Customer getCustomerById(int custID);

	int addCustomer(Customer cust); // returns assigned id

	String editCustomerById(int custID); // returns String of employee's information to look at

	String editCustomerByName(Customer cust); // returns String of employee's information to look at

	String deleteCustomerById(int custID); // returns String "Successful" or "Unsuccessful" depending on operation
											// success
}
