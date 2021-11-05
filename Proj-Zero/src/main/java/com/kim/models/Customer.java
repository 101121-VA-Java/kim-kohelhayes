package com.kim.models;

import java.util.*;

public class Customer extends User {

	private int c_id;
	//use math.util.round? to round to two decimal places on these three
	private double creditLine;
	//creditLine = amountAvailable + amountDue;
	private double amountDue;
	//if amountDue = creditLine then amountAvailable = 0
	

	public Customer(int id, String name, String email, String password, int c_id,
			double creditLine, double amountDue) {
		super(id, name, email, password);
		this.c_id = c_id;
		this.creditLine = creditLine;
		this.amountDue = amountDue;
	}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
	}


	public double getCreditLine() {
		return creditLine;
	}


	public void setCreditLine(double creditLine) {
		this.creditLine = creditLine;
	}


	public double getAmountDue() {
		return amountDue;
	}


	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}


	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", creditLine=" + creditLine + ", amountDue=" + amountDue + ", id=" + id
				+ ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(amountDue, c_id, creditLine);
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
		Customer other = (Customer) obj;
		return Double.doubleToLongBits(amountDue) == Double.doubleToLongBits(other.amountDue) && c_id == other.c_id
				&& Double.doubleToLongBits(creditLine) == Double.doubleToLongBits(other.creditLine);
	}
	
	
	
	
	
}
