package com.revature.driver;

//import java.time.LocalDate;

//import com.revature.models.Item;
import com.revature.services.ListServices;

public class Driver {

	public static void main(String[] args) {
//        Item almondMilk = new Item("Almond Milk", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//        Item coconutFlakes = new Item("Coconut Flakes", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//        Item sunflowerSeeds = new Item("Sunflower Seeds", LocalDate.parse("2021-11-01"), LocalDate.parse("2021-11-10"));
//        
//        System.out.println(almondMilk.itemName + "  was added to the list on " + almondMilk.addedOn + " and is due by " + almondMilk.needByDate);
//        System.out.println(coconutFlakes.itemName + "  was added to the list on " + coconutFlakes.addedOn + " and is due by " + coconutFlakes.needByDate);
//        System.out.println(sunflowerSeeds.itemName + "  was added to the list on " + sunflowerSeeds.addedOn + " and is due by " + sunflowerSeeds.needByDate);
        
        
        ListServices oopService = new ListServices();
        
        oopService.doEncapsulation();
        oopService.doInheritance();
        oopService.doPolymorphism();
        oopService.doAbstraction();
        
        
    }
	
	
	
	
	
	
	

}
