package com.ddbb.client.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDTO {

	private String proName;
	private int proPrice;
	private int proAccount;
	private String proImg;
	private String proContentImg;
	private String proCategory;
	private int proSales;
	private int proSort;
	private int proReviewTotal;
	
	
	public int getProReviewTotal() {
		return proReviewTotal;
	}
	public void setProReviewTotal(int proReviewTotal) {
		this.proReviewTotal = proReviewTotal;
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
	public int getProAccount() {
		return proAccount;
	}
	public void setProAccount(int proAccount) {
		this.proAccount = proAccount;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public String getProContentImg() {
		return proContentImg;
	}
	public void setProContentImg(String proContentImg) {
		this.proContentImg = proContentImg;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public int getProSales() {
		return proSales;
	}
	public void setProSales(int proSales) {
		this.proSales = proSales;
	}
	public int getProSort() {
		return proSort;
	}
	public void setProSort(int proSort) {
		this.proSort = proSort;
	}
	
}
