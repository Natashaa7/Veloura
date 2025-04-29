package com.veloura.model;

import java.time.LocalDate;

public class CustomerModel {
	private String title;
	private String username;
	private String customerName;
	private String email;
	private String phno;
	private LocalDate dob;
	private String password;
	
	
	public CustomerModel() {
	}
	
	public CustomerModel(String username, String pasword) {
		this.username = username;
		this.password = pasword;
	}

	public CustomerModel(String title, String username, String customerName, String email, String phno, LocalDate dob,
			String password) {
		super();
		this.title = title;
		this.username = username;
		this.customerName = customerName;
		this.email = email;
		this.phno = phno;
		this.dob = dob;
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}