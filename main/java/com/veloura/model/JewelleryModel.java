package com.veloura.model;

/**
 * JewelleryModel represents a piece of jewelry in the Veloura system.
 * It includes attributes such as material, diamond weight, gold weight, stock quantity, and cost.
 */
public class JewelleryModel {
	private int code;
	private String name;
	private String material;
	private double diamond;
	private int gold;
	private int stock;
	private int cost;
	private String image;

	/**
	 * Constructor with all fields including jewelry code.
	 *
	 * @param code     the unique code for the jewelry
	 * @param name     the name of the jewelry piece
	 * @param material the material of the jewelry (e.g., Gold, Platinum)
	 * @param diamond  the diamond weight in carats
	 * @param gold     the gold weight in grams
	 * @param stock    the available stock quantity
	 * @param cost     the cost of the jewelry
	 * @param image    the image URL or file name of the jewelry
	 */
	public JewelleryModel(int code, String name, String material, double diamond, int gold, int stock, int cost, String image) {
		this.code = code;
		this.name = name;
		this.material = material;
		this.diamond = diamond;
		this.gold = gold;
		this.stock = stock;
		this.cost = cost;
		this.image = image;
	}

	/**
	 * Constructor without code (typically used for inserts where code is auto-generated).
	 *
	 * @param name     the name of the jewelry piece
	 * @param material the material of the jewelry
	 * @param diamond  the diamond weight in carats
	 * @param gold     the gold weight in grams
	 * @param stock    the available stock quantity
	 * @param cost     the cost of the jewelry
	 * @param image    the image URL or file name of the jewelry
	 */
	public JewelleryModel(String name, String material, double diamond, int gold, int stock, int cost, String image) {
		this.name = name;
		this.material = material;
		this.diamond = diamond;
		this.gold = gold;
		this.stock = stock;
		this.cost = cost;
		this.image = image;
	}

	public JewelleryModel(int code, String name, String material, double diamond, int gold, int stock, int cost) {
		super();
		this.code = code;
		this.name = name;
		this.material = material;
		this.diamond = diamond;
		this.gold = gold;
		this.stock = stock;
		this.cost = cost;
	}

	/**
	 * Constructor with minimal fields (used for dashboard data).
	 *
	 * @param code the unique code for the jewelry
	 * @param name the name of the jewelry
	 * @param cost the total cost of the jewelry
	 */
	public JewelleryModel(int code, String name, int cost) {
		super();
		this.code = code;
		this.name = name;
		this.cost = cost;
	}

	/**
	 * Gets the code of the jewelry.
	 *
	 * @return the jewelry code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code of the jewelry.
	 *
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the name of the jewelry.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the jewelry.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the material of the jewelry.
	 *
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Sets the material of the jewelry.
	 *
	 * @param material the material to set
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Gets the diamond weight in carats.
	 *
	 * @return the diamond weight
	 */
	public double getDiamond() {
		return diamond;
	}

	/**
	 * Sets the diamond weight in carats.
	 *
	 * @param diamond the diamond weight to set
	 */
	public void setDiamond(double diamond) {
		this.diamond = diamond;
	}

	/**
	 * Gets the gold weight in grams.
	 *
	 * @return the gold weight
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * Sets the gold weight in grams.
	 *
	 * @param gold the gold weight to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * Gets the available stock quantity.
	 *
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Sets the available stock quantity.
	 *
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Gets the cost of the jewelry.
	 *
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Sets the cost of the jewelry.
	 *
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Gets the image associated with the jewelry.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image for the jewelry.
	 *
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
}
