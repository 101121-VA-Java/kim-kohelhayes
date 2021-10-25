package com.revature.models;
import com.revature.models.Item;
import com.revature.models.RecurringItem;
import java.time.*;

public class List {
	
	private String listName;
	private String listDescription;
	
	public List(String listName, String listDescription) {
		super();
		this.listName = listName;
		this.listDescription = listDescription;
		
		
	}
	
	public void polymorphismEx() {
		
		RecurringItem milk = new RecurringItem(("Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
		
		
		
	}

	
	

}
