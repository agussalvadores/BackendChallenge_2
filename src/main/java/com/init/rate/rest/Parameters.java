package com.init.rate.rest;

public class Parameters {
	private String brand;
	private double amount;
	
	public Parameters(String brand, double amount) {
		this.brand=brand;
		this.amount=amount;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
