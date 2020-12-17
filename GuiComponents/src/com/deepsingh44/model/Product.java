package com.deepsingh44.model;

public class Product {
	private int id;
	private String name;
	private float price;
	private int quantity;
	private String category;
	private String date;

	public Product() {
	}

	public Product(String name, float price, int quantity, String category, String date) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
