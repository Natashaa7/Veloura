package com.veloura.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.veloura.config.DbConfig;
import com.veloura.model.CustomerModel;

/**
 * RegisterService handles the business logic for customer registration,
 * including interacting with the database to store customer details.
 */
public class RegisterService {
	
	private Connection connection;
	
	/**
	 * 
	 * LMU ID: 23048637
	 * NAME: NATASHA BABU
	 * 
	 * Constructor that initializes the database connection.
	 */
	public RegisterService() {
		try {
			this.connection = DbConfig.getDbConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // Log the exception
		} catch (SQLException e) {
			e.printStackTrace(); // Log the exception
		}
	}
	
	/**
	 * Registers a new customer in the database.
	 * 
	 * @param customerModel the CustomerModel object containing the customer details
	 * @return Boolean indicating whether the registration was successful (true) or not (false),
	 *         or null if there was an error connecting to the database
	 */
	public Boolean registerCustomer(CustomerModel customerModel) {
		if (this.connection == null) {
			System.out.println("Database did not connect");
			return null;
		}
		
		String insertQuery = "INSERT INTO customer (title, username, customer_name, email, phno, dob, password) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

			// Insert customer details
			insertStmt.setString(1, customerModel.getTitle());
			insertStmt.setString(2, customerModel.getUsername());
			insertStmt.setString(3, customerModel.getCustomerName());
			insertStmt.setString(4, customerModel.getEmail());
			insertStmt.setString(5, customerModel.getPhno());
			insertStmt.setDate(6, Date.valueOf(customerModel.getDob()));
			insertStmt.setString(7, customerModel.getPassword());

			// Execute the insertion and check if it was successful
			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during customer registration: " + e.getMessage());
			e.printStackTrace(); // Log the exception
			return null;
		}
	}
}
