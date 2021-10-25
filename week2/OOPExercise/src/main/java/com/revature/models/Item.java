package com.revature.models;

import java.time.LocalDate;

public class Item 
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

	public static void main(String[] args) {
        Item almondMilk = new Item("Almond Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
        Item coconutFlakes = new Item("Coconut Flakes", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
        Item sunflowerSeeds = new Item("Sunflower Seeds", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
        
        System.out.println(almondMilk.itemName + "  was added to the list on " + almondMilk.addedOn + " and is due by " + almondMilk.needByDate);
        System.out.println(coconutFlakes.itemName + "  was added to the list on " + coconutFlakes.addedOn + " and is due by " + coconutFlakes.needByDate);
        System.out.println(sunflowerSeeds.itemName + "  was added to the list on " + sunflowerSeeds.addedOn + " and is due by " + sunflowerSeeds.needByDate);
        
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

	public void addItemToList() {
		
	}
	
	

	

}
