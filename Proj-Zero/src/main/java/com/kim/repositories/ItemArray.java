package com.kim.repositories;

import com.kim.exceptions.CustomerNotFoundException;
import com.kim.exceptions.ItemNotFoundException;
import com.kim.models.Customer;
import com.kim.models.Item;

public class ItemArray implements ItemDAO {
	
	private Item[] items = { 
			new Item(0, "cheese", "swiss cheese", 1, 1),
			new Item(1, "moscato", "red moscato", 3, 1),
			new Item(2, "diapers", "size newborn", 4, 1) };
	
	public ItemArray() {
		super();
	}
	
	@Override
	public Item[] getAllItems() {
		return this.items;
	}

	@Override
	public Item getItemById(int Id) throws ItemNotFoundException {
		for (int i = 0; i < items.length; i++) {
			if (Id == items[i].getId()) {
				return items[i];
			}
		}
			throw new ItemNotFoundException();
	}

	@Override
	public int addItem(Item item) {
		// Create a tempArray of size items + 1
		Item[] tempArray = new Item[items.length + 1];
		int iterator = 0;
		for (; iterator < items.length; iterator++) {
			tempArray[iterator] = items[iterator];
		}
		//iterator is the value of the last index of the new array
		//(items.length) set iterator to be the id for the new item
		item.setId(iterator);
		// adding the new item to the array
		tempArray[iterator] = item;
		//assign the newly created array to items
		items = tempArray;
		return iterator;
	}

	@Override
	public Item editItemById(int ID) throws ItemNotFoundException  {
		for (int i = 0; i < items.length; i++) {
			if (ID == items[i].getId()) {
				// update this item
				//items[i].setter(items.getter());
				return items[i];
			}

		}

		throw new ItemNotFoundException();
	}
	
	@Override
	public boolean deleteItemById(int itemID) {
		// TODO Auto-generated method stub
		return false;
	}

}
