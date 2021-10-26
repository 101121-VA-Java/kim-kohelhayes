package com.revature.models;

import java.util.Objects;

public abstract class List {
	
	private String listName;
	private String listDescription;
	
	public List(String listName, String listDescription) {
		super();
		this.listName = listName;
		this.listDescription = listDescription;
		
		
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getListDescription() {
		return listDescription;
	}

	public void setListDescription(String listDescription) {
		this.listDescription = listDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		List other = (List) obj;
		return Objects.equals(listName, other.listName);
	}
	
	

	
	

}
