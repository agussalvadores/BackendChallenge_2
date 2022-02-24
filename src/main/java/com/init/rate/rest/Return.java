package com.init.rate.rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Return {
	
	private String brand;
	private double start_amount;
	private double rate_p;
	private double rate_v;
	private double total_amount;
	
	public Return(String brand, double start_amount, double rate_p, double rate_v, double total_amount) {
		this.brand = brand;
		this.start_amount = start_amount;
		this.rate_p = rate_p;
		this.rate_v = rate_v;
		this.total_amount = total_amount;
	}
	
	public JsonObject toJson() {
		JsonObjectBuilder builderJson = Json.createObjectBuilder();
		builderJson.add("brand", this.brand)
					.add("start_amount", this.start_amount)
					.add("rate_p", this.rate_p)
					.add("rate_v", this.rate_v)
					.add("total_amount", this.total_amount);
		JsonObject result = builderJson.build();
		return result;
	}
	
	public double getStart_amount() {
		return start_amount;
	}
	public void setStart_amount(double start_amount) {
		this.start_amount = start_amount;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getRate_p() {
		return rate_p;
	}
	public void setRate_p(double rate_p) {
		this.rate_p = rate_p;
	}
	public double getRate_v() {
		return rate_v;
	}
	public void setRate_v(double rate_v) {
		this.rate_v = rate_v;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

}
