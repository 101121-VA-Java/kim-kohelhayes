package com.kim.models;

import java.util.Objects;

public class Employee extends User {
	
	private int e_id;
	private boolean manager;
	private String managerName;

	public Employee(int id, String name, String username, String password, 
			int e_id, boolean manager, String managerName) {
		super(id, name, username, password);
		this.e_id = e_id;
		this.manager = manager;
		this.managerName = managerName;
	}

	

	public Employee(int id, String name, String username, String password, int e_id) {
		super(id, name, username, password);
		this.e_id = e_id;
	}

	

	public Employee(int id, String name, String username, String password) {
		super(id, name, username, password);
		// TODO Auto-generated constructor stub
	}



	public Employee(int id2) {
		super(id2);
		// TODO Auto-generated constructor stub
	}



	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", manager=" + manager + ", managerName=" + managerName + ", id=" + id
				+ ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(e_id, manager, managerName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return e_id == other.e_id && manager == other.manager && Objects.equals(managerName, other.managerName);
	}

	
	
}