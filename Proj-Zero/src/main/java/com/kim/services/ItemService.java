package com.kim.services;

import java.util.List;

import com.kim.exceptions.ItemNotFoundException;
import com.kim.models.Item;
import com.kim.repositories.ItemDAO;
import com.kim.repositories.ItemPostgreSQL;

public class ItemService {
	private ItemDAO itmDao = new ItemPostgreSQL();
	
	public ItemService() {
		super();
		List<Item> itms = itmDao.getAllItems();
		for (Item i : itms) {
			System.out.println(i);
		}
	}


	public void addItem(Item newItm) {

		/*
		 * add business logic here to manipulate u before storage
		 * when employees add a new Item they are going to input 
		 * 		- item.name
		 * 		- item.description
		 * 		- item.dept_id //see department table for names
		 * 
		 * System should assign 
		 * 	-item status - 1
		 * 		
		 */
		
		
	}
	
	public Item getItemById(int id) throws ItemNotFoundException  {

		if(id > 0) { // just for example's sake
		throw new ItemNotFoundException();
		} 

		return null;
	}

	
}
