package com.veloura.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.veloura.config.DbConfig;
import com.veloura.model.JewelleryModel;

/**
 * 
 * LMU ID: 23048637  
 * NAME: NATASHA BABU
 * 
 * ProductsDashboardService handles the business logic for managing jewellery products.
 * It includes operations such as adding, updating, deleting, and retrieving jewellery from the database.
 */
public class ProductsDashboardService {

	private Connection connection;

	/**
	 * Constructor that initializes the database connection using DbConfig.
	 */
	public ProductsDashboardService() {
		try {
			this.connection = DbConfig.getDbConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // Log the exception
		} catch (SQLException e) {
			e.printStackTrace(); // Log the exception
		}
	}

	/**
	 * Adds a new jewellery item to the database.
	 * 
	 * @param jewelleryModel the JewelleryModel object containing the jewellery details
	 * @return true if the jewellery was successfully added, false if not, or null if the database connection failed
	 */
	public Boolean addJewellery(JewelleryModel jewelleryModel) {
		if (this.connection == null) {
			System.out.println("Database did not connect");
			return null;
		}

		String insertQuery = "INSERT INTO jewellery (jewellery_name, material, diamonds, gold, stock, total_cost, image)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
			insertStmt.setString(1, jewelleryModel.getName());
			insertStmt.setString(2, jewelleryModel.getMaterial());
			insertStmt.setDouble(3, jewelleryModel.getDiamond());
			insertStmt.setInt(4, jewelleryModel.getGold());
			insertStmt.setInt(5, jewelleryModel.getStock());
			insertStmt.setInt(6, jewelleryModel.getCost());
			insertStmt.setString(7, jewelleryModel.getImage());

			return insertStmt.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error during adding product: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves all jewellery items from the database.
	 * 
	 * @return a List of JewelleryModel containing all jewellery records
	 */
	public List<JewelleryModel> getAllJewellery() {
		List<JewelleryModel> jewelleryList = new ArrayList<>();
		String query = "SELECT * FROM jewellery";

		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				JewelleryModel model = new JewelleryModel(
					rs.getInt("jewellery_id"),
					rs.getString("jewellery_name"),
					rs.getString("material"),
					rs.getDouble("diamonds"),
					rs.getInt("gold"),
					rs.getInt("stock"),
					rs.getInt("total_cost"),
					rs.getString("image")
				);
				jewelleryList.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jewelleryList;
	}

	/**
	 * Deletes a jewellery item from the database by its ID.
	 * 
	 * @param code the unique jewellery ID
	 * @return true if the deletion was successful, false otherwise
	 */
	public boolean deleteJewelleryById(int code) {
		String deleteQuery = "DELETE FROM jewellery WHERE jewellery_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
			stmt.setInt(1, code);
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Searches for jewellery by partial or full name match.
	 * 
	 * @param jewelleryName the name (or partial name) of the jewellery item
	 * @return a List of JewelleryModel items that match the search criteria
	 */
	public List<JewelleryModel> searchJewelleryByName(String jewelleryName) {
		List<JewelleryModel> jewelleryList = new ArrayList<>();
		String query = "SELECT * FROM jewellery WHERE jewellery_name LIKE ?";

		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, "%" + jewelleryName + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				JewelleryModel model = new JewelleryModel(
					rs.getInt("jewellery_id"),
					rs.getString("jewellery_name"),
					rs.getString("material"),
					rs.getDouble("diamonds"),
					rs.getInt("gold"),
					rs.getInt("stock"),
					rs.getInt("total_cost"),
					rs.getString("image")
				);
				jewelleryList.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jewelleryList;
	}

	/**
	 * Updates an existing jewellery item in the database.
	 * 
	 * @param jewelleryModel the JewelleryModel object containing updated jewellery information
	 * @return true if the update was successful, false otherwise
	 */
	public boolean updateJewellery(JewelleryModel jewelleryModel) {
		String updateQuery = "UPDATE jewellery SET jewellery_name=?, material=?, diamonds=?, gold=?, stock=?, total_cost=? WHERE jewellery_id=?";
		try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
			stmt.setString(1, jewelleryModel.getName());
			stmt.setString(2, jewelleryModel.getMaterial());
			stmt.setDouble(3, jewelleryModel.getDiamond());
			stmt.setInt(4, jewelleryModel.getGold());
			stmt.setInt(5, jewelleryModel.getStock());
			stmt.setInt(6, jewelleryModel.getCost());
			stmt.setInt(7, jewelleryModel.getCode());

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
