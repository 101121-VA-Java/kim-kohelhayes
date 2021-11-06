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
import com.kim.models.Employee;
import com.kim.util.ConnectionUtil;

public class EmployeePostgreSQL implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employees;";
		List<Employee> employees = new ArrayList<>();

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				int e_id = rs.getInt("employees.id");
				boolean manager = rs.getBoolean("manager");
				String managerName = rs.getString("manager_name");
				Employee newEmp = new Employee(id, name, username, password, e_id,
						manager, managerName);
				employees.add(newEmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException io ) {
			io.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int empID) throws EmployeeNotFoundException {
		String sql = "select * from employees where employees.id = ? ";
		Employee emp = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, empID); // 1 refers to the first '?'

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("n_me");
				String username = rs.getString("username");
				String password = rs.getString("pswrd");
				int e_id = rs.getInt("employees.id");
				boolean manager = rs.getBoolean("manager");
				String managerName = rs.getString("manager_name");
				emp = new Employee(id, name, username, password, e_id, manager, managerName);
			} else throw new EmployeeNotFoundException();
				
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			
		}
		
		return emp;
		
		
	}

	@Override
	public boolean addEmployee(Employee emp) {
		
		String sql = "insert into employees (n_me, username, pswrd, manager, manager_name) "
				+ "values (?, ?, ?, ?, ?);";

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getPassword());
			ps.setBoolean(4, emp.isManager());
			ps.setString(5, emp.getManagerName());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return false; 
	}

	@Override
	public boolean editEmployee(Employee emp) throws EmployeeNotFoundException {
		String sql = "update employees set id = ?, n_me = ?, username = ?, pswrd = ?,"
				+ " employees.id = ?, manager = ?, manager_name = ?;";

		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, emp.getId());
			ps.setString(2,	emp.getName());
			ps.setString(3, emp.getUsername());
			ps.setString(4, emp.getPassword());
			ps.setInt(5, emp.getE_id());
			ps.setBoolean(6, emp.isManager());
			ps.setString(7, emp.getManagerName());

			rowsChanged = ps.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	

	@Override
	public boolean deleteEmployee(int empID) {
		String sql = "delete from employees where employees.id = ?;";
		
		int rowsChanged = -1;

		try (Connection con = ConnectionUtil.getConnectionFromFile();) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, empID);
			
			rowsChanged = ps.executeUpdate();
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

}
