package com.kim.controllers;

import java.util.List;
import java.util.Scanner;

import com.kim.models.Item;
import com.kim.models.User;
import com.kim.repositories.ItemDAO;
import com.kim.repositories.ItemPostgreSQL;
import com.kim.repositories.UserDAO;
import com.kim.repositories.UserPostgreSQL;
import com.kim.services.ItemService;

public class CustomerMenu {
	
	private UserPostgreSQL ups = new UserPostgreSQL();
	UserDAO ud = new UserPostgreSQL();
	private ItemPostgreSQL ips = new ItemPostgreSQL();
	ItemDAO itd = new ItemPostgreSQL();
	ItemService isr = new ItemService();


	// TODO Auto-generated method stub
	/*
	 * makeAnOffer
	 * viewAmountOwed
	 *  - bonus - makeAPayment
	 */


	public void makeOffer(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public void viewAllMyItems(int cuId, Scanner scan) {
		List<Item> myItems = ips.getAllMyItems(cuId);
		for(Item i : myItems) {
			System.out.println(i);
		}
		
	}

	public void viewAllSaleItems(Scanner scan) {
		List<Item> saleItems = ips.getAllSaleItems();
		for(Item i : saleItems) {
			System.out.println(i);
		}
		
	}

	public void viewAmountOwed(int cuId, Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public void makePayment(int cuId, Scanner scan) {
		// TODO Auto-generated method stub
		
	}
}
