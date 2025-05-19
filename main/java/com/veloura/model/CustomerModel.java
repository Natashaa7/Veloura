package com.veloura.model;

import java.time.LocalDate;

/**
 * CustomerModel represents the data model for a customer in the Veloura system.
 * It contains personal and account-related details such as name, email, phone number, date of birth, and credentials.
 */
public class CustomerModel {
	private String title;
	private String username;
	private String customerName;
	private String email;
	private String phno;
	private LocalDate dob;
	private String password;

	/**
	 * Default constructor.
	 */
	public CustomerModel() {
	}

	/**
	 * Constructor with only username and password.
	 *
	 * @param username the customer's username
	 * @param password the customer's password
	 */
	public CustomerModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Full-argument constructor for initializing all customer fields.
	 *
	 * @param title        the customer's title (e.g., Mr., Ms.)
	 * @param username     the customer's username
	 * @param customerName the customer's full name
	 * @param email        the customer's email address
	 * @param phno         the customer's phone number
	 * @param dob          the customer's date of birth
	 * @param password     the customer's password
	 */
	public CustomerModel(String title, String username, String customerName, String email, String phno, LocalDate dob,
			String password) {
		this.title = title;
		this.username = username;
		this.customerName = customerName;
		this.email = email;
		this.phno = phno;
		this.dob = dob;
		this.password = password;
	}

	/**
	 * Gets the title of the customer.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the customer.
	 *
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the customer's full name.
	 *
	 * @return the customer name
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Sets the customer's full name.
	 *
	 * @param customerName the name to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * Gets the customer's email address.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the customer's email address.
	 *
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the customer's phone number.
	 *
	 * @return the phone number
	 */
	public String getPhno() {
		return phno;
	}

	/**
	 * Sets the customer's phone number.
	 *
	 * @param phno the phone number to set
	 */
	public void setPhno(String phno) {
		this.phno = phno;
	}

	/**
	 * Gets the customer's date of birth.
	 *
	 * @return the date of birth
	 */
	public LocalDate getDob() {
		return dob;
	}

	/**
	 * Sets the customer's date of birth.
	 *
	 * @param dob the date of birth to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/**
	 * Gets the customer's password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the customer's password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
