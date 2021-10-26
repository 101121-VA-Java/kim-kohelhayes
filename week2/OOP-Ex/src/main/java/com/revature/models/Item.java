package com.revature.models;

import java.time.LocalDate;

import com.revature.interfaces.Listable;

public class Item implements Listable 
{
	
	private String itemName;
	private LocalDate addedOn;
	private LocalDate needByDate;
	
	public Item(String itemName, LocalDate addedOn, LocalDate needByDate) 
	{
		super();
		this.itemName = itemName;
		this.addedOn = addedOn;
		this.needByDate = needByDate;
	}

	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public LocalDate getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDate addedOn) {
		this.addedOn = addedOn;
	}

	public LocalDate getNeedByDate() {
		return needByDate;
	}

	public void setNeedByDate(LocalDate needByDate) {
		this.needByDate = needByDate;
	}

	
	public void makePlural() {
		setItemName(getItemName()+"s");
	}
	

	

}

