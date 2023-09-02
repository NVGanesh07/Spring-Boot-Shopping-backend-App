package com.shopping.model;

public class Customer {
	
	private int customerid;
	private String customerName;
	private String Gender;
	private long contact;
	private String email;
	private String address;
	private int pincode;
	private String username;
	private String password;
	
	
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public Customer(int customerid, String customerName, String gender, long contact, String email, String address,
			int pincode, String username, String password) {
		super();
		this.customerid = customerid;
		this.customerName = customerName;
		Gender = gender;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.pincode = pincode;
		this.username = username;
		this.password = password;
	}
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
