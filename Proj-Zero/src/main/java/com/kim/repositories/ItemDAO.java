package com.kim.repositories;

import com.kim.exceptions.ItemNotFoundException;
import com.kim.models.Item;

public interface ItemDAO {

	Item[] getAllItems();

	Item getItemById(int Id) throws ItemNotFoundException;

	int addItem(Item item);

	Item editItemById(int itemID) throws ItemNotFoundException;// returns whole item

	boolean deleteItemById(int itemID);// returns true or false
	
	/*
	 * String[] viewItemByOffer(Item offer); // or should it be viewOffersByItem?
	 * String[] viewItemsByDept(int deptID); String[] viewAllDepartments();
	 *
	 * I think these three will be accessed through PostgreSQL so I am not sure how
	 * to build them.
	 *
	 **/

}
