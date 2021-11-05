package com.kim.drivers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.kim.controllers.UIController;
import com.kim.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {

		// Call UIController Here to start program
		UIController ui = new UIController();
		ui.run();
		
		
		
//		try {
//			Connection c = ConnectionUtil.getConnectionFromFile();
//			System.out.println(c.getMetaData().getDriverName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
	}

}
