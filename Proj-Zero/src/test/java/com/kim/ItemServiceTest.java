package com.kim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kim.repositories.ItemDAO;
import com.kim.repositories.ItemPostgreSQL;

public class ItemServiceTest {

	private ItemDAO itmDao = new ItemPostgreSQL();
	private ItemPostgreSQL ips = new ItemPostgreSQL();
	
	@BeforeEach
	public void setup() {
		
	}
	
	
	
	
	
}
