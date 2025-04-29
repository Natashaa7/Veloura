package com.veloura.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.veloura.config.DbConfig;
import com.veloura.model.CustomerModel;

public class RegisterService {
	
	private Connection connection;
	
	public RegisterService() {
		try {
			this.connection = DbConfig.getDbConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Boolean registerCustomer(CustomerModel customerModel) {
		if (this.connection == null)
		{
			System.out.println("Database did not connect");
			return null;
			
		}
		
		String insertQuery = "INSERT INTO customer (title, username, customer_name, email, phno, dob, password) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

			/* Fetch program ID
			programStmt.setString(1, studentModel.getProgram().getName());
			ResultSet result = programStmt.executeQuery();
			int programId = result.next() ? result.getInt("program_id") : 1;*/

			// Insert customer details
			insertStmt.setString(1, customerModel.getTitle());
			insertStmt.setString(2, customerModel.getUsername());
			insertStmt.setString(3, customerModel.getCustomerName());
			insertStmt.setString(4, customerModel.getEmail());
			insertStmt.setString(5, customerModel.getPhno());
			insertStmt.setDate(6, Date.valueOf(customerModel.getDob()));
			insertStmt.setString(7, customerModel.getPassword());

			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during customer registration: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	

}
