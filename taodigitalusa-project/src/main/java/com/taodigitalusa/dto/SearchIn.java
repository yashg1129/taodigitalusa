package com.taodigitalusa.dto;

public class SearchIn {

	private String productName;
	private double minPrice;
	private double maxPrice;
	private String minPostedDate;
	private String maxPostedDate;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getMinPostedDate() {
		return minPostedDate;
	}

	public void setMinPostedDate(String minPostedDate) {
		this.minPostedDate = minPostedDate;
	}

	public String getMaxPostedDate() {
		return maxPostedDate;
	}

	public void setMaxPostedDate(String maxPostedDate) {
		this.maxPostedDate = maxPostedDate;
	}
}
