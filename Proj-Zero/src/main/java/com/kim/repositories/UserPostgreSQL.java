package com.kim.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kim.models.Item;
import com.kim.models.User;
import com.kim.util.ConnectionUtil;

public class UserPostgreSQL implements UserDAO {

	@Override
	public List<User> getAllUsers() {
		String sql = "select * from users order by id";
		List<User> users = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				String position = rs.getString("pstn");

				User newUser = new User(id, name, username, password, position);
				users.add(newUser);
			}
		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		return users;
	}

	@Override
	public User getUserById(int id) {
		String sql = "select * from Users where u_id = ? ";
		User usr = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); 	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				String position = rs.getString("pstn");

				usr = new User(id, name, username, password, position);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return usr;
	}

	@Override
	public User getUser(User user) {
		String sql = "select * from users where username = ? AND" 
					+ "	pswrd = ?;";
		User usr = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				String position = rs.getString("pstn");

				usr = new User(id, name, username, password, position);
			}
		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		return usr;
	}
	
	@Override
	public int getUserId(User user) {
		String sql = "select id from users where username = ? AND" 
					+ "	pswrd = ?;";
		int userID = 0;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");

				userID = id;
			}
		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		return userID;
	}


	@Override
	public int addUser(User user) {
		int newId = -1;
		String sql = "insert into users (n_me, username, pswrd, pstn)"
				+ " values (?, ?, ?, ?)  returning id;";
		

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPosition());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				newId = rs.getInt("id");
			}

		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		return newId;	


	}


	@Override
	public boolean editUser(User user) {
		String sql = "update employees set id = ?, n_me = ?, username = ?, pswrd = ?,"
				+ " pstn = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPosition());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}

	}


	@Override
	public boolean deleteUser(int userID) {
		String sql = "delete from users where id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userID);

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> getOwedAmt(int usrId) {
		String sql = "SELECT c.amount_owed AS amt_owed"
				+ " FROM customers c"
				+ " JOIN users u ON c.user_id = u.id"
				+ " WHERE u.id = ?;";
		
		List<User> users = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, usrId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				double amountOwed = rs.getDouble("amt_owed");
				
				User nwUsr = new User(amountOwed);
				users.add(nwUsr);
			}

		} catch (SQLException | IOException it) {
			it.printStackTrace();

		}

		return users;
	}
	
//	@Override
//	public List<User> makePayment(int usrId) {
//		String sql = "SELECT u.n_me AS u_name,"
//				+ " c.amount_owed AS amt_owed,"
//				+ " c.amount_owed - SUM(p.amount) AS new_amount_owed"
//				+ " FROM customers c"
//				+ " JOIN customer_payments cp ON cp.c_id = c.c_id"
//				+ " JOIN payments p ON p.pay_id = cp.p_id"
//				+ " JOIN users u ON c.user_id = u.id"
//				+ " WHERE u.id = ?"
//				+ " GROUP BY u.n_me, c.amount_owed;";
//		
//		List<User> users = new ArrayList<>();
//		
//		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setInt(1, usrId);
//
//			ResultSet rs = ps.executeQuery();
//
//			if (rs.next()) {
//				
//				double amountOwed = rs.getDouble("amt_owed");
//				
//				User nwUsr = new User(amountOwed);
//				users.add(nwUsr);
//			}
//
//		} catch (SQLException | IOException it) {
//			it.printStackTrace();
//
//		}
//
//		return users;
//	}
//	
	




}
