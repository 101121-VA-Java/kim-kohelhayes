package com.kim.repositories;

import java.util.List;

import com.kim.exceptions.ItemNotFoundException;
import com.kim.models.Item;
import com.kim.models.User;

public interface ItemDAO {

	List<Item> getAllItems();

	Item getItemById(int itemId);

	int addItem(Item item);

	boolean editItem(Item item);// returns whole item

	boolean deleteItem(int itemID);// returns true or false

	List<Item> getAllSaleItems();
	
	List<Item> getAllMyItems(int usrId);
	
}
