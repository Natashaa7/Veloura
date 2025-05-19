package com.veloura.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veloura.config.DbConfig;
import com.veloura.model.JewelleryModel;

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
public class AdminDashboardService {
	private Connection connection;

	/**
	 * Constructs an AdminDashboardService object and initializes a database
	 * connection using DbConfig.
	 */
	public AdminDashboardService() {
		try {
			this.connection = DbConfig.getDbConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // Log the exception
		}
	}

	/**
	 * Retrieves the total number of customers from the database.
	 *
	 * @return the total count of customers
	 */
	public int getTotalCustomerCount() {
		int count = 0;
		String query = "SELECT COUNT(*) FROM customer";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); // Get the count from the first column
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * Retrieves the total number of jewellery items in stock from the database.
	 *
	 * @return the total stock count of jewellery items
	 */
	public int getTotalJewelleryCount() {
		int count = 0;
		String query = "SELECT SUM(stock) FROM jewellery";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1); // Get the count from the first column
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * Retrieves the total cost of all jewellery items in the database.
	 *
	 * @return the total jewellery cost as an integer
	 */
	public int getTotalJewelleryCost() {
		int totalCost = 0;
		String query = "SELECT SUM(total_cost) FROM jewellery";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				totalCost = rs.getInt(1); // Get the SUM from the first column
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCost;
	}
	
	/**
	 * Retrieves the top 5 most expensive jewellery items from the database.
	 *
	 * @return a list of the top 5 expensive jewellery items
	 */
	public List<JewelleryModel> getTop5ExpensiveJewellery() {
	    List<JewelleryModel> jewelleryList = new ArrayList<>();
	    String query = "SELECT jewellery_id, jewellery_name, total_cost FROM jewellery ORDER BY total_cost DESC LIMIT 5";

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            int code = rs.getInt("jewellery_id");
	            String name = rs.getString("jewellery_name");
	            int cost = rs.getInt("total_cost");
	            JewelleryModel jewellery = new JewelleryModel(code, name, cost);
	            jewelleryList.add(jewellery);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return jewelleryList;
	}

	/**
	 * Retrieves the 5 most recently added jewellery items from the database.
	 *
	 * @return a list of the 5 most recently added jewellery items
	 */
	public List<JewelleryModel> getRecentlyAdded() {
	    List<JewelleryModel> jewelleryList = new ArrayList<>();
	    String query = "SELECT jewellery_id, jewellery_name, total_cost FROM jewellery ORDER BY jewellery_id DESC LIMIT 5";

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            int code = rs.getInt("jewellery_id");
	            String name = rs.getString("jewellery_name");
	            int cost = rs.getInt("total_cost");
	            JewelleryModel jewellery = new JewelleryModel(code, name, cost);
	            jewelleryList.add(jewellery);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return jewelleryList;
	}
}
