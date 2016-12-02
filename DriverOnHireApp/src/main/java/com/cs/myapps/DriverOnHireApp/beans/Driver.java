package com.cs.myapps.DriverOnHireApp.beans;

import org.ektorp.support.CouchDbDocument;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.format.annotation.NumberFormat;





public class Driver extends CouchDbDocument{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/*	@JsonProperty("_rev")
	private String rev;
	@JsonProperty("_id")
	private String id;*/
	
	private String name;
	
	@NumberFormat(style = Style.CURRENCY)
	private float salary;
	private String city;
	

	private String email;
	
	private String phoneNo;
	
	private boolean isAvailable=true;;
	
	
	public Driver(String name, float salary, String city, String email, String phoneNo) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	
	/*@JsonProperty("_rev")
	public String getRevision() {
		return rev;
	}

	@JsonProperty("_rev")
	public void setRevision(String rev) {
		this.rev = rev;
	}


	public String getId() {
		return id;
	}


	public void setId(String _id) {
		this.id = _id;
	}*/

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Driver() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
