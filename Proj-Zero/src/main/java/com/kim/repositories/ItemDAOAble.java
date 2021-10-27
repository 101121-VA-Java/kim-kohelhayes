package com.kim.repositories;

import com.kim.models.Item;

public interface ItemDAOAble {

	Item[] getAllItems();
	Item getItemById(int Id);
	int addItem(Item item);
	String editItemById(int itemID);//returns whole item
	String deleteItemById(int itemID);//returns "Delete Successful" or "Delete Unsuccessful"
	/*
	*  String[] viewItemByOffer(Item offer); // or should it be viewOffersByItem?
	*  String[] viewItemsByDept(int deptID);
	*  String[] viewAllDepartments();
	*
	*	I think these three will be accessed through PostgreSQL so I am not sure how
	*	to build them.
	*
	**/
	
}
