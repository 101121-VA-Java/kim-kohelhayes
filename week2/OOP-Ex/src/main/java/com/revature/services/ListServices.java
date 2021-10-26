package com.revature.services;

import java.time.LocalDate;

import com.revature.models.GroceryList;
import com.revature.models.Item;
import com.revature.models.RecurringItem;

public class ListServices {

		
	public void doEncapsulation() {
//      Item almondMilk = new Item("Almond Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//      Item coconutFlakes = new Item("Coconut Flakes", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//      Item sunflowerSeeds = new Item("Sunflower Seeds", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//      
//
//      System.out.println(almondMilk.getItemName() + "  was added to the list on " + almondMilk.getAddedOn() + " and is due by " + almondMilk.getNeedByDate());
//      System.out.println(coconutFlakes.getItemName() + "  was added to the list on " + coconutFlakes.getAddedOn() + " and is due by " + coconutFlakes.getNeedByDate());
//      System.out.println(sunflowerSeeds.getItemName() + "  was added to the list on " + sunflowerSeeds.getAddedOn() + " and is due by " + sunflowerSeeds.getNeedByDate());
//    
//      
//      almondMilk.setItemName("almondmilk");
//      coconutFlakes.setItemName("Coconut");
//      sunflowerSeeds.setItemName("sunflowerSeeds");
//      
//      System.out.println(almondMilk.getItemName() + "  was added to the list on " + almondMilk.getAddedOn() + " and is due by " + almondMilk.getNeedByDate());
//      System.out.println(coconutFlakes.getItemName() + "  was added to the list on " + coconutFlakes.getAddedOn() + " and is due by " + coconutFlakes.getNeedByDate());
//      System.out.println(sunflowerSeeds.getItemName() + "  was added to the list on " + sunflowerSeeds.getAddedOn() + " and is due by " + sunflowerSeeds.getNeedByDate());

	}
		
	public void doInheritance() {
//	    Item almondMilk = new Item("Almond Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//	    
//	    System.out.println(almondMilk.getItemName() + "  was added to the list on " + almondMilk.getAddedOn() + " and is due by " + almondMilk.getNeedByDate());
//		
//		RecurringItem ni = new RecurringItem("new item", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//		
//		System.out.println(ni.getItemName() + "  was added to the list on " + ni.getAddedOn() + " and is due by " + ni.getNeedByDate());
	}
	
	public void doPolymorphism() {
		Item almondMilk = new Item("Almond Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
		RecurringItem ni = new RecurringItem("new item", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
		
		ni.putsBackOnList();
		System.out.println(ni.getItemName() + "  was added to the list on " + ni.getAddedOn() + " and is due by " + ni.getNeedByDate());
		
		ni.putsBackOnList(5);
		System.out.println(ni.getItemName() + "  was added to the list on " + ni.getAddedOn() + " and is due by " + ni.getNeedByDate());
		
		
		almondMilk.makePlural();
		System.out.println(almondMilk.getItemName());
		ni.makePlural();
		System.out.println(ni.getItemName());
		
	}
	
	public void doAbstraction() {
//		GroceryList gl = new GroceryList("Grocery List", "It's a grocery list");
//		
//		System.out.println(gl.toString());
	}
}


//OOP exercise
//- Create your own example of OOP principles in Java!
//	- your project should includes examples of each of the pillars and comments explaining how it's related to OOP
//	- Ideally it would print examples to the console as well.
//	
//- MVP (Minimum Viable Product)
//	- Using proper package structure, include at least these concepts
//		- Encapsulation
//			- Access Modifiers
//			- Setters/Getters
//		- Inheritance
//			- extends
//			- super
//		- Polymorphism
//			- method overloading
//			- method overriding
//		- Abstraction
//			- abstract keyword
//			- interface keyword
//	- Create a custom exception, throw it, and handle it!