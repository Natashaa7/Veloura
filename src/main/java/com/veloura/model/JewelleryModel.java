package com.veloura.model;

public class JewelleryModel {
	private String name;
	private String material;
	private double diamond;
	private int gold;
	private int stock;
	private int cost;
	
	public JewelleryModel(String name, String material, double diamond, int gold, int stock, int cost) {
		super();
		this.name = name;
		this.material = material;
		this.diamond = diamond;
		this.gold = gold;
		this.stock = stock;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getDiamond() {
		return diamond;
	}

	public void setDiamond(double diamond) {
		this.diamond = diamond;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
}
