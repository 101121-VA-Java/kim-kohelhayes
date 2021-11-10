package com.kim.models;

import java.util.Objects;

public class User {

	private int id;
	private String name;
	private String username;
	private String password;
	private String position;
	private double amountOwed;

	public User(int id, String name, String username, String password, String position) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.position = position;
	}

	public User(String name, String username, String password, String position) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.position = position;
	}
	
	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(double amountOwed) {
		super();
		this.amountOwed = amountOwed;
	}
	
	public User(int id2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String email) {
		this.username = email;
	}

	public String getPassword() {
		return position;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getAmountOwed() {
		return amountOwed;
	}

	public void setAmountOwed(double amountOwed) {
		this.amountOwed = amountOwed;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", position="
				+ position + ", amountOwed=" + amountOwed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amountOwed, id, name, password, position, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Double.doubleToLongBits(amountOwed) == Double.doubleToLongBits(other.amountOwed) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(position, other.position) && Objects.equals(username, other.username);
	}

	
	
}
