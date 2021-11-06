package com.kim.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kim.exceptions.EmployeeNotFoundException;
import com.kim.exceptions.ItemNotFoundException;
import com.kim.models.Employee;
import com.kim.models.Item;
import com.kim.util.ConnectionUtil;

public class ItemPostgreSQL implements ItemDAO {

	@Override
	public List<Item> getAllItems() {
		String sql = "select * from items;";
		List<Item> items = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String description = rs.getString("description");
				int dept_id = rs.getInt("dept_id");
				int status_id = rs.getInt("status_id");
				Item newItem = new Item(id, name, description, dept_id, status_id);
				items.add(newItem);
			}
		} catch (SQLException it) {
			it.printStackTrace();
		}catch (IOException it ) {
			it.printStackTrace();
		}
		
		return items;
	}

	@Override
	public Item getItemById(int itemID) throws ItemNotFoundException {
		String sql = "select * from items where items.id = ? ";
		Item item = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, itemID); // 1 refers to the first '?'

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String description = rs.getString("description");
				int dept_id = rs.getInt("dept_id");
				int status_id = rs.getInt("status_id");
				item = new Item(id, name, description, dept_id, status_id);
			} else throw new ItemNotFoundException();
				
		} catch (ItemNotFoundException it) {
			it.printStackTrace();
		
		} catch (SQLException | IOException it) {
			it.printStackTrace();
			
		}
		
		return item;
	}

	@Override
	public boolean addItem(Item item) {
		String sql = "insert into items (n_me, description, dept_id, status_id) "
				+ "values (?, ?, ?, ?, ?);";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getName());
			ps.setString(2, item.getDescription());
			ps.setInt(3, item.getDept_id());
			ps.setInt(4, item.getStatus_id());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException | IOException it) {
			it.printStackTrace();
		}

		return false; 
	}

	@Override
	public boolean editItem(Item item) throws ItemNotFoundException {
		String sql = "update items set id = ?, n_me = ?, description = ?, dept_id = ?,"
				+ " status_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, item.getId());
			ps.setString(2, item.getName());
			ps.setString(3, item.getDescription());
			ps.setInt(4, item.getDept_id());
			ps.setInt(5, item.getStatus_id());

			rowsChanged = ps.executeUpdate();
			
			} catch (SQLException it) {
				it.printStackTrace();
			} catch (IOException it) {
				it.printStackTrace();
			}
			
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteItem(int itemID) {
		String sql = "delete from items where employees.id = ?;";
		
		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, itemID);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException | IOException it) {
			it.printStackTrace();
		}
		
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

}
