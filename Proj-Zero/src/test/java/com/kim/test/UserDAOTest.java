//package com.kim.test;
//
//import static org.junit.jupiter.api.Assertions.assertArrayEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import com.kim.exceptions.UserNotFoundException;
//import com.kim.models.User;
//import com.kim.repositories.UserDAO;
//import com.kim.repositories.UserPostgreSQL;
//
//public class UserDAOTest {
//
//	private UserDAO usr = new UserPostgreSQL();
//
//	@BeforeEach
//	public void setup() {
//		
//	}
//
//	@Test
//	public void getAllEmployees() {
//		
//
//		List<User> actual = usr.getAllUsers();
//		assertArrayEquals(expected, actual);
//	}
//
//	@Test
//	public void userNotFoundById() throws UserNotFoundException {
//
//		assertThrows(UserNotFoundException.class, () -> usr.getUserById(10),
//				"Expected getUserById(10) to throw, but it didn't");
//
//	}
//
//	@Test
//	public void getUserById() throws UserNotFoundException {
//
//		User expected = new User();
//		int id = 2;
//		User actual = usr.getUserById(id);
//		assertEquals(expected, actual);
//
//	}
//
//	@Test
//	public void addEmployeeValid() {
//		
//
//		// Adding an employee
//		usr.addUser(new User());
//
//		assertArrayEquals(expected, usr.getAllUsers());
//	}
//
//	@Test
//	public void userNotFoundByName() throws UserNotFoundException {
//
//		User brad = new User();
//
//		assertThrows(UserNotFoundException.class, () -> usr.editUser(brad),
//				"Expected getUserByName(3) to throw, but it didn't");
//
//	}
//
//	@Test
//	public void editUser() throws UserNotFoundException {
//
//	
//		User actual = usr.editUser(user);
//		assertEquals(expected, actual);
//
//	}
//
//	@Test
//	public void deleteUser() {
//
//		boolean expected = true;
//		int id = 2;
//		boolean actual = usr.deleteUser(id);
//		assertEquals(expected, actual);
//	}
//
//}
