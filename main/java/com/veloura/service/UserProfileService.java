package com.veloura.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.veloura.config.DbConfig;
import com.veloura.model.CustomerModel;

/**
 * AdminDashboardService handles the business logic required for the
 * administrative dashboard in the Veloura application.
 * 
 * It includes methods to retrieve total customer count and the total
 * jewellery cost from the database.
 * 
 * LMU ID: 23048637
 * NAME: NATASHA BABU
 */
public class UserProfileService {
	private Connection connection;

	/**
	 * Constructs an AdminDashboardService object and initializes a database
	 * connection using DbConfig.
	 */
	public UserProfileService() {
		try {
			this.connection = DbConfig.getDbConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // Log the exception
		}
	}
	
	/**
	 * Retrieves a CustomerModel object from the database based on the provided username.
	 *
	 * @param username the username of the customer to retrieve
	 * @return a CustomerModel object if the user exists; otherwise, null
	 */
	public CustomerModel getUserByUsername(String username) {
	    CustomerModel customer = null;
	    String query = "SELECT * FROM customer WHERE username = ?";

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, username);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            customer = new CustomerModel(
	                rs.getString("title"),
	                rs.getString("username"),
	                rs.getString("customer_name"),
	                rs.getString("email"),
	                rs.getString("phno"),
	                rs.getDate("dob").toLocalDate(),
	                rs.getString("password")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return customer;
	}
	
	/**
	 * Updates the customer profile in the database with the provided details.
	 *
	 * @param title             the title of the customer (e.g., Mr, Ms, Mrs)
	 * @param username          the username of the customer
	 * @param customerName      the full name of the customer
	 * @param email             the email address of the customer
	 * @param phno              the phone number of the customer
	 * @param dob               the date of birth of the customer in YYYY-MM-DD format
	 * @param encryptedPassword the new encrypted password if it is being updated, or null otherwise
	 * @return true if the update was successful; false otherwise
	 */
	public boolean updateUserProfile(String title, String username, String customerName, String email,
	    String phno, String dob, String encryptedPassword) {
		String query;
		boolean includePassword = encryptedPassword != null;
		
		if (includePassword) {
			query = "UPDATE customer SET title = ?, customer_name = ?, email = ?, phno = ?, dob = ?, password = ? WHERE username = ?";
		} else {
			query = "UPDATE customer SET title = ?, customer_name = ?, email = ?, phno = ?, dob = ? WHERE username = ?";
		}
		
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, title);
			stmt.setString(2, customerName);
			stmt.setString(3, email);
			stmt.setString(4, phno);
			stmt.setDate(5, java.sql.Date.valueOf(dob));
		
			if (includePassword) {
				stmt.setString(6, encryptedPassword);
				stmt.setString(7, username);
			} else {
				stmt.setString(6, username);
			}
			
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}