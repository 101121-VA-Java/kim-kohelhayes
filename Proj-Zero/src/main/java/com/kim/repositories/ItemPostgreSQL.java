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
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String description = rs.getString("description");
				String dept = rs.getString("dept");
				int status_id = rs.getInt("status_id");
				Item newItem = new Item(id, name, description, dept, status_id);
				items.add(newItem);
			}

		} catch (SQLException | IOException it) {
			it.printStackTrace();
		}

		return items;
	}

	@Override
	public List<Item> getAllSaleItems() {
		String sql = "SELECT item_id, item_name, description,"
				+ " dept FROM items WHERE status_id = 1;";
		List<Item> items = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String description = rs.getString("description");
				String dept = rs.getString("dept");
				Item newItem = new Item(id, name, description, dept);
				items.add(newItem);
			}

		} catch (SQLException | IOException it) {
			it.printStackTrace();
		}

		return items;
	}

	@Override
	public Item getItemById(int itemID) {
		String sql = "select * from items where id = ? ";
		Item item = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, itemID); // 1 refers to the first '?'

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				String description = rs.getString("description");
				String dept = rs.getString("dept");
				int status_id = rs.getInt("status_id");
				item = new Item(id, name, description, dept, status_id);
			}

		} catch (SQLException | IOException it) {
			it.printStackTrace();

		}

		return item;
	}

	@Override
	public int addItem(Item item) {
		String sql = "insert into items (item_name, description, dept, status_id)"
				+ " values (?, ?, ?, ?, ?);";
		int itId = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item.getName());
			ps.setString(2, item.getDescription());
			ps.setString(3, item.getDept());
			ps.setInt(4, item.getStatus_id());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				itId = rs.getInt("id");
			}
		} catch (SQLException | IOException u) {
			u.printStackTrace();
		}

		return itId;
	}

	@Override
	public boolean editItem(Item item) {
		String sql = "update items set item_id = ?, item_name = ?,"
				+ " description = ?, dept = ?, status_id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, item.getId());
			ps.setString(2, item.getName());
			ps.setString(3, item.getDescription());
			ps.setString(4, item.getDept());
			ps.setInt(5, item.getStatus_id());

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

	@Override
	public boolean deleteItem(int itemID) {
		String sql = "delete from items where item_id = ?;";

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

	@Override
	public List<Item> getAllMyItems(int usrId) {
		String sql = "SELECT i.item_name AS item_name"
				+ " FROM customer_items ci"
				+ " JOIN customers c ON ci.cust_id = c.c_id"
				+ " JOIN users u ON c.user_id = u.id"
				+ " JOIN items i ON ci.item_id = i.item_id"
				+ " WHERE u.id = ?;";
		
		List<Item> items = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, usrId); // 1 refers to the first '?'

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				String name = rs.getString("item_name");
				
				Item nwItm = new Item(name);
				items.add(nwItm);
			}

		} catch (SQLException | IOException it) {
			it.printStackTrace();

		}

		return items;
	}

}
