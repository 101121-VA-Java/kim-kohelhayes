package com.kim.models;

public class Employee extends User {

	private boolean manager;
	private String managerName;

	public Employee(int id, String name, String email, String password, boolean manager, String managerName) {
		super(id, name, email, password);
		this.manager = manager;
		this.managerName = managerName;
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
		return "Employee [manager=" + manager + ", managerName=" + managerName + ", id=" + id + ", name=" + name
				+ ", email=" + email + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (manager ? 1231 : 1237);
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
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
		if (manager != other.manager)
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		return true;
	}

}
