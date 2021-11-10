package com.kim.models;

import java.util.Objects;

public class Item {

	private int id;
	private String name;
	private String description;
	private String dept;
	private int status_id;

	public Item(int id, String name, String description, String dept, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dept = dept;
		this.status_id = status_id;
	}

	public Item(String name, String description, String dept, int status_id) {
		super();
		this.name = name;
		this.description = description;
		this.dept = dept;
		this.status_id = status_id;
	}

	public Item(int id, String name, String description, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.dept = dept;
	}
	
	public Item(String name, String description, String dept) {
		super();
		this.name = name;
		this.description = description;
		this.dept = dept;
	}
	
	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Item(String name) {
		super();
		this.name = name;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", dept=" + dept
				+ ", status_id=" + status_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept, description, id, name, status_id);
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
				&& Objects.equals(name, other.name) && status_id == other.status_id;
	}

}