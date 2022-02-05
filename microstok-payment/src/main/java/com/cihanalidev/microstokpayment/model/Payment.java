package com.cihanalidev.microstokpayment.model;

public class Payment {
	
	    private int id;
	    private int count;
	    private double price;   
	    private double unitPrice;
	    private String productCode;
	    private String date;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
		public String getProductCode() {
			return productCode;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
	
}
