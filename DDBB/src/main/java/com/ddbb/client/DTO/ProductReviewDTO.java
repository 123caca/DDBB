package com.ddbb.client.DTO;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class ProductReviewDTO {

	private int proReviewNum;
	private double proReviewOrderNum;
	private String proReviewProName;
	private String proReviewUserId;
	private String proReviewUserName;
	private int proReviewScore;
	private String proReviewImg;
	private String proReviewContent;
	private Date proReviewDate;

	public double getProReviewOrderNum() {
		return proReviewOrderNum;
	}
	public void setProReviewOrderNum(double proReviewOrderNum) {
		this.proReviewOrderNum = proReviewOrderNum;
	}
	public int getProReviewNum() {
		return proReviewNum;
	}
	public void setProReviewNum(int proReviewNum) {
		this.proReviewNum = proReviewNum;
	}
	public String getProReviewProName() {
		return proReviewProName;
	}
	public void setProReviewProName(String proReviewProName) {
		this.proReviewProName = proReviewProName;
	}
	public String getProReviewUserId() {
		return proReviewUserId;
	}
	public void setProReviewUserId(String proReviewUserId) {
		this.proReviewUserId = proReviewUserId;
	}
	public String getProReviewUserName() {
		return proReviewUserName;
	}
	public void setProReviewUserName(String proReviewUserName) {
		this.proReviewUserName = proReviewUserName;
	}
	public int getProReviewScore() {
		return proReviewScore;
	}
	public void setProReviewScore(int proReviewScore) {
		this.proReviewScore = proReviewScore;
	}
	public String getProReviewImg() {
		return proReviewImg;
	}
	public void setProReviewImg(String proReviewImg) {
		this.proReviewImg = proReviewImg;
	}
	public String getProReviewContent() {
		return proReviewContent;
	}
	public void setProReviewContent(String proReviewContent) {
		this.proReviewContent = proReviewContent;
	}
	public Date getProReviewDate() {
		return proReviewDate;
	}
	public void setProReviewDate(Date proReviewDate) {
		this.proReviewDate = proReviewDate;
	}	
	
}
