package com.kim.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kim.exceptions.CustomerNotFoundException;
import com.kim.models.Customer;
import com.kim.models.Item;
import com.kim.util.ConnectionUtil;

public class CustomerPostgreSQL implements CustomerDAO {

	@Override
	public List<Customer> getAllCustomers() {
		String sql = "select * from customers;";
		List<Customer> customers = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				int c_id = rs.getInt("customer.id");
				double creditLine = rs.getDouble("credit_line");
				double amountDue = rs.getDouble("amount_due");
				Customer newCust = new Customer(id, name, username, password, c_id, creditLine, amountDue);
				customers.add(newCust);
			}
		} catch (SQLException c) {
			c.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}

		return customers;
	}

	@Override
	public Customer getCustomerById(int custID) {
		String sql = "select * from customers where customer.id = ? ";
		Customer cust = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, custID); // 1 refers to the first '?'

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				int c_id = rs.getInt("customer.id");
				double creditLine = rs.getDouble("credit_line");
				double amountDue = rs.getDouble("amount_due");
				cust = new Customer(id, name, username, password, c_id, creditLine, amountDue);
			}
		} catch (SQLException | IOException c) {
			c.printStackTrace();
		}
		return cust;
	}

	@Override
	public boolean addCustomer(Customer cust) {

		String sql = "insert into customers (n_me, username, pswrd, credit_line, amount_due) "
				+ "values (?, ?, ?, ?, ?);";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, cust.getName());
			ps.setString(2, cust.getUsername());
			ps.setString(3, cust.getPassword());
			ps.setDouble(4, cust.getCreditLine());
			ps.setDouble(5, cust.getAmountDue());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException | IOException c) {
			c.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean editCustomer(Customer cust) {
		String sql = "update customers set id = ?, n_me = ?, username = ?, pswrd = ?,"
				+ " customer.id = ?, credit_line = ?, amount_due = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, cust.getId());
			ps.setString(2, cust.getName());
			ps.setString(3, cust.getUsername());
			ps.setString(4, cust.getPassword());
			ps.setInt(5, cust.getC_id());
			ps.setDouble(6, cust.getCreditLine());
			ps.setDouble(7, cust.getAmountDue());

			rowsChanged = ps.executeUpdate();

		} catch (SQLException c) {
			c.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean deleteCustomer(int custID) {
		String sql = "delete from customers where customers.id = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, custID);

			rowsChanged = ps.executeUpdate();

		} catch (SQLException | IOException c) {
			c.printStackTrace();
		}

		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double viewCustomerCreditLine(int custID) {
		String sql = "select credit_line from customers where customers.id = ?;";
		double dbl = 0;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, custID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				double creditLine = rs.getDouble("credit_line");
				dbl = creditLine;
			}

		} catch (SQLException c) {
			c.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}

		return dbl;

	}

	@Override
	public double viewCustomerDue(int custID) {
		String sql = "select amount_due from customers where customers.id = ?;";
		double dbl = 0;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, custID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				double amountDue = rs.getDouble("amount_due");
				dbl = amountDue;
			}

		} catch (SQLException c) {
			c.printStackTrace();
		} catch (IOException c) {
			c.printStackTrace();
		}

		return dbl;

	}

	@Override
	public List<Item> viewItemsBought(int custID) {
//		String sql = "select * from items where select item.id from customer_items where customers.id = ?;";

		return null;
	}

}