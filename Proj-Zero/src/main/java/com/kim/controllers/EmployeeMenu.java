package com.kim.controllers;
import java.util.List;
import java.util.Scanner;

import com.kim.models.Item;
import com.kim.repositories.ItemPostgreSQL;
import com.kim.services.ItemService;


public class EmployeeMenu {
	
	private ItemPostgreSQL ips = new ItemPostgreSQL();
	private ItemService isr = new ItemService();
	
	// TODO Auto-generated method stub
	/*
	 * finalizeSale  
	 * 		--  System has to 
	 * 			- update item to sold
	 * 			- update customer_items table with owner 
	 * 			- reject any other offers on item
	 * deleteItem
	 * viewAllPayments
	 *  - bonus - editAnItem
	 *  - bonus - admin can 
	 *  	- makeAnEmployee
	 *  	- makeEmployeeCustomer
	 */


	public void viewAllItems(Scanner scan) {
		List<Item> allItems = ips.getAllItems();
		for(Item i : allItems) {
			System.out.println(i);
		}
		
	}

	public void addItem(Scanner scan) {
		System.out.println("Please enter the item's name: ");
		String name = scan.nextLine();
			if(name.length() > 15 ) {
				System.out.println("Name is too long! Try Again!");
				name = scan.nextLine();
			}
		System.out.println("Please enter a description for the item: ");
		String description = scan.nextLine();
			if(description.length() > 15 ) {
				System.out.println("Description is too long! Try Again!");
				description = scan.nextLine();
			}
		Item nwItm = new Item(name, description);
		System.out.println("Please enter: ");
		System.out.println("1: GROCERY ");
		System.out.println("2: PETS");
		System.out.println("3: BABY");
		System.out.println("4: GARDEN");
		int dptNum = scan.nextInt();
			if(dptNum != 1 || dptNum != 2 || dptNum != 3 || dptNum != 4 ) {
				System.out.println("Department Must Be 1, 2, 3, or 4! Try Again!");
				dptNum = scan.nextInt();
			}			
		boolean nwMd = isr.getItemDetails(nwItm, dptNum);
		System.out.println("Item was created: " + nwMd);
		
	}

	public void viewAllBidsPerItem(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public void acceptSale(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public void viewAllPayments(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public void deleteItem(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
}
