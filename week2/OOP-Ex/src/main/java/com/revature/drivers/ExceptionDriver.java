package com.revature.drivers;
import com.revature.exceptions.AlmondMilkException;

public class ExceptionDriver {
	public static void main(String[] args) {
		
		
//		ExceptionDriver ed = new ExceptionDriver();
		
		int a = 12;
		int b = 0;
		
		
		
		
		
		try 
		{
			// put risky code here | code that can throw an exception
			
			divide(a,b);
			
		} catch (AlmondMilkException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Can't divide by zero!");
			
		} finally 
		{
			// always executes
			
//			System.out.println("Whatever");
		
		}	
		
		
	}
	
	public static int divide(int a, int b) throws AlmondMilkException {
		return a / b;
	}
	
	
	
}


