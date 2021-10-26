package com.revature.models;

public class GroceryList extends List {

	public GroceryList(String listName, String listDescription) {
		super(listName, listDescription);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getListName() + ", " + getListDescription()+ " ";
	}

	
	
	
}
