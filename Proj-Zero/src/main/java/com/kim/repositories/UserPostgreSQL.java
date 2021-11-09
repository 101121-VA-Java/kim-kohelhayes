package com.kim.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public int getUserId(User user) {
		String sql = "select id" + " from users" + " where" + "	n_me = ? AND" + "	username = ? AND" + "	pswrd = ?;";
		int userID = 0;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());

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


}
