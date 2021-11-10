package com.kim.controllers;

import java.util.Scanner;

import com.kim.models.User;
import com.kim.repositories.UserPostgreSQL;

public class UserController {

	private CustomerMenu cm;
	private EmployeeMenu em;
	private UIController ui;
	private UserPostgreSQL ups = new UserPostgreSQL();

	public UserController() {
		cm = new CustomerMenu();
		em = new EmployeeMenu();
//		ui = new UIController();
	}

	

	public void customerMenu(User currentUser, Scanner scan) {
		int cuId = ups.getUserId(currentUser);
		boolean run = true;

		while (run) {
			System.out.println("What Would You Like to do?");
			System.out.println("1: Make an Offer on An Item");
			System.out.println("2: View All of Your Items");
			System.out.println("3: View All Items For Sale");
			System.out.println("4: View Amount Owed");
			System.out.println("5: Make a Payment");
			System.out.println("6: Return to Previous Menu");
			
			String choice = scan.nextLine();

			switch (choice) {
			case "1":
				cm.makeOffer(scan);
				break;
			case "2":
				cm.viewAllMyItems(cuId,scan);
				break;
			case "3":
				cm.viewAllSaleItems(scan);
				break;
			case "4":
				cm.viewAmountOwed(cuId,scan);
				break;
			case "5":
				cm.makePayment(cuId,scan);
				break;
			case "6":
//				ui.run();
				break;
			default:
				System.out.println("Invalid input.");
//				ui.run();
			}
		}

		scan.close();

	}

	public void employeeMenu(User currentUser, Scanner scan) {

		boolean run = true;

		while (run) {
			System.out.println("What Would You Like to do?");
			System.out.println("1: View All Items");
			System.out.println("2: Add an Item");
			System.out.println("3: Look at Bids");
			System.out.println("4: Accept a Bid");
			System.out.println("5: View all Payments");
			System.out.println("6: Delete Item");
			System.out.println("7: Return to Previous Menu");
//			System.out.println("7: Edit an Item");
//			System.out.println("Admin-1: Add Employee");
//			System.out.println("Admin-2: Delete Employee");

			String choice = scan.nextLine();

			switch (choice) {
			case "1":
				em.viewAllItems(scan);
				break;
			case "2":
				em.addItem(scan);
				break;
			case "3":
				em.viewAllBidsPerItem(scan);
				break;
			case "4":
				em.acceptSale(scan);
				break;
			case "5":
				em.viewAllPayments(scan);
				break;
			case "6":
				em.deleteItem(scan);
				break;
			case "7":
//				ui.run();
				break;
			default:
				System.out.println("Invalid input.");
//				ui.run();
			}
		}

		scan.close();

	}

}
