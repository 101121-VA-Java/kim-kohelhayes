package com.kim.repositories;

import java.util.List;

import com.kim.exceptions.ItemNotFoundException;
import com.kim.models.Item;

public interface ItemDAO {

	List<Item> getAllItems();

	Item getItemById(int itemId) throws ItemNotFoundException;

	boolean addItem(Item item);

	boolean editItem(Item item) throws ItemNotFoundException;// returns whole item

	boolean deleteItem(int itemID);// returns true or false
	
}
