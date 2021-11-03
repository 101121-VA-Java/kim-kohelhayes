package com.kim.models;

import java.util.Objects;

public class Item {

	private int id;
	private String name;
	private String description;
	private int dept; // 1=grocery, 2=pet_supply, 3 wine & spirits, 4 baby stuff, etc...
	private int status;
	// private String[] department_name; // 1 grocery, 2 pet_supply, 3 wine & spirits, 4 baby stuff, etc...
	// private String[] statusMeaning;// 1 for sale, 2 sale pending, 3 sold  ...
	// private double[] offers; // Do these three in PostgreSQL

	public Item(int id, String name, String description, int dept, int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dept = dept;
		this.status = status;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", dept=" + dept
				+ ", department_name=" + ", status=" + status + ", statusMeaning=" + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept, description, id, name, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return dept == other.dept && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(name, other.name) && status == other.status;
	}

}
