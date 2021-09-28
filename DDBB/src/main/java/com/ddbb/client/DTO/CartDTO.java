package com.ddbb.client.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class CartDTO {
	private String userId;
	private String proName;
	private int proPrice;
	private String proImg;
	private int addAccount;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public int getAddAccount() {
		return addAccount;
	}
	public void setAddAccount(int addAccount) {
		this.addAccount = addAccount;
	}
	
}
