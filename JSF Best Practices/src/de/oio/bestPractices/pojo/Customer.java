package de.oio.bestPractices.pojo;

import java.io.Serializable;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	private String firstname;
	
	private String lastname;
	
	private int customerId;

	public Customer(String firstname, String lastname, int customerId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.customerId = customerId;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString(){
		return firstname+" "+lastname+", Customer ID "+customerId;
	}
}
