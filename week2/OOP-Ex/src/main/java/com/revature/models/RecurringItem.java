package com.revature.models;

import java.time.*;

public class RecurringItem extends Item {

	public RecurringItem(String itemName, LocalDate addedOn, LocalDate needByDate) {
		super(itemName, addedOn, needByDate);
		// TODO Auto-generated constructor stub
		
	}

		
	public void putsBackOnList(String name) {
		//Puts the RecurringItem back on the list after it's needByDate has passed
		this.setNeedByDate(getNeedByDate().plusDays(10));
	}
	
	public void putsBackOnList(String name, int addDays) {
		//Puts the RecurringItem back on the list after it's needByDate has passed
		this.setNeedByDate(getNeedByDate().plusDays(10));
	}

	@Override
	public void addItemToList() {
		
	}
	
}
