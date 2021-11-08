package com.kim.drivers;

import com.kim.controllers.UIController;

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

//		EmployeeDAO ed = new EmployeePostgreSQL();
//		
//		UserDAO ud = new UserPostgreSQL();
//		
////		User mabel = new User("Mabel", "mburmaster3", "NwTVtez");
//		
//		User user = new User("Bruno", "brunod15", "pa$$98&%");
//
//		int newUser = ud.addUser(user);
//		
//		System.out.println("Generated new user: " + newUser);
//		
//		int bradID = ud.getUserId(user);
//		
//		System.out.println("Get userId: " + bradID);
//		
//		Employee emp = new Employee(false, "Admin", bradID);
//		
//		int newEmp = ed.addEmployee(emp);
//		
//		System.out.println("Made new employee with userID " +  newEmp);
		
		
//		

//		System.out.println("Get employeeById 4:" + ed.getEmployeeById(4));
//		
//		List<Employee> emps = ed.getAllEmployees();
//		for (Employee e : emps) {
//			System.out.println(e);
//		}





		
		
		
//		System.out.println("Deleted columns: " + ed.deleteEmployee(newEmp));
		
		
	}

}
