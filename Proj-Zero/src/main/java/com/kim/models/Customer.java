

package com.kim.models;
import java.util.*;

public class Customer extends User {

	//use math.util.round? to round to two decimal places on these three
	private double creditLine;
	//creditLine = amountAvailable + amountDue;
	private double amountAvailable;
	//amountAvailable cannot exceed creditLine;
	private double amountDue;
	//if amountDue = creditLine then amountAvailable = 0
	//private ArrayList<Item> itemList;

	public Customer(int id, String name, String email, String password, 
			double creditLine, double amountAvailable, double amountDue
			//ArrayList<Item> itemList
			) {
		super(id, name, email, password);
		this.creditLine = creditLine;
		this.amountAvailable = amountAvailable;
		this.amountDue = amountDue;
		//this.itemList = new ArrayList<Item>();
	}
	

	
	
	
}
