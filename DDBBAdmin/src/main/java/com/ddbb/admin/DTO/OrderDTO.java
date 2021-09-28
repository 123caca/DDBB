package com.ddbb.admin.DTO;

public class OrderDTO {
	private String orderProNumber;
	private String orderUserId;
	private String orderUserName;
	private String orderDate;
	private String orderProImg;
	private String orderProName;
	private int orderProPrice;
	private int orderProAccount;
	private int orderTracking;
	
	public String getOrderProNumber() {
		return orderProNumber;
	}
	public void setOrderProNumber(String orderProNumber) {
		this.orderProNumber = orderProNumber;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	public String getOrderUserName() {
		return orderUserName;
	}
	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderProImg() {
		return orderProImg;
	}
	public void setOrderProImg(String orderProImg) {
		this.orderProImg = orderProImg;
	}
	public String getOrderProName() {
		return orderProName;
	}
	public void setOrderProName(String orderProName) {
		this.orderProName = orderProName;
	}
	public int getOrderProPrice() {
		return orderProPrice;
	}
	public void setOrderProPrice(int orderProPrice) {
		this.orderProPrice = orderProPrice;
	}
	public int getOrderProAccount() {
		return orderProAccount;
	}
	public void setOrderProAccount(int orderProAccount) {
		this.orderProAccount = orderProAccount;
	}
	public int getOrderTracking() {
		return orderTracking;
	}
	public void setOrderTracking(int orderTracking) {
		this.orderTracking = orderTracking;
	}

}
