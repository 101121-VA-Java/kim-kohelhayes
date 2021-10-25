package com.revature.services;

import java.time.LocalDate;

import com.revature.models.Item;

public class ListServices {

		
	public void doEncapsulation() {
      Item almondMilk = new Item("Almond Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
      Item coconutFlakes = new Item("Coconut Flakes", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
      Item sunflowerSeeds = new Item("Sunflower Seeds", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
      
      System.out.println(almondMilk.getItemName());
      
      almondMilk.setItemName("almondmilk");
      System.out.println(almondMilk.getItemName());
	}
		
	public void doInheritance() {
		
	}
	
	public void doPolymorphism() {
	
	}
	
	public void doAbstraction() {
		
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