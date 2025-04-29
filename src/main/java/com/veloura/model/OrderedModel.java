package com.veloura.model;

import java.time.LocalDateTime;

public class OrderedModel {
	private LocalDateTime orderDate;
	private int totalAmount;
	
	public OrderedModel(LocalDateTime orderDate, int totalAmount) {
		super();
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
