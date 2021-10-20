package com.revature;

import java.util.Scanner;
import java.util.Random;

public class ScannerPractice {

	static Scanner sc = new Scanner(System.in);

		public static void main(String[] args) {
			
			menuScreen();
			
			int num = sc.nextInt();
			sc.nextLine();
			
			while (num !=  3) {
				if (num == 1) {
					menuOne();
					break;
				} else if (num == 2) {
					menuTwo();
					break;
				} else {
					menuThree();
				}
			}
	}

	public static void menuScreen() {
		System.out.println("Welcome!  Please Choose an Option:");
		System.out.println("Option 1 - Get a Random Number between 0 & 10");
		System.out.println("Option 2 - Reverse Your Word");
		System.out.println("Option 3 - Exit Program");
	}

	public static void menuOne() {
		Random rand = new Random();
		int randint = rand.nextInt(10);
		System.out.println("Your random number is: " + randint);
		//sc.nextLine();
		menuScreen();
	}

	public static void menuTwo() {
		System.out.println("Please enter a word");
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.reverse());
		//sc.nextLine();
		menuScreen();
	}
	
	public static void menuThree() {
		System.out.println("Thank you for Playing!");
	}

}