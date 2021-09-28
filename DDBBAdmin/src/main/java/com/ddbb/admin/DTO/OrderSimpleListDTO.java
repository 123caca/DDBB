package com.ddbb.admin.DTO;

public class OrderSimpleListDTO {
	private String orderProNumber;
	private String orderUserId;
	private String orderUserName;
	private String orderDate;
	private String orderProImg;
	private String orderProName;
	private int orderTracking;
	private int orderSimTotalCost;
	
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
	public int getOrderTracking() {
		return orderTracking;
	}
	public void setOrderTracking(int orderTracking) {
		this.orderTracking = orderTracking;
	}
	public int getOrderSimTotalCost() {
		return orderSimTotalCost;
	}
	public void setOrderSimTotalCost(int orderSimTotalCost) {
		this.orderSimTotalCost = orderSimTotalCost;
	}

}
