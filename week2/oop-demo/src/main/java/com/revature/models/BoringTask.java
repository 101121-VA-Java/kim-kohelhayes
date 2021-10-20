package com.revature.models;

import java.time.LocalDate;

public class BoringTask extends Tasks{

	
	public BoringTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoringTask(String name, LocalDate dueDate) {
		super(name, dueDate);
		// TODO Auto-generated constructor stub
	}

	public void procrastination() {
		/*
		 * Because dueDate is a private field in Task, it is not visible/accessible via the child class
		 * in order to access we could make the field not private or use setters/getters
		 */
		this.setDueDate(this.getDueDate().plusDays(1));
	}


}