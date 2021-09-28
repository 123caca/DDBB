package com.ddbb.client.DTO;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class ProductQnaDTO {

	private int proQnaNum;
	private String proQnaProName;
	private String proQnaTitle;
	private String proQnaContent;
	private String proQnaUserName;
	private String proQnaUserId;
	private Date proQnaDate;
	private String proQnaAnswer;
	private int proQnaSecret;
	
	public int getProQnaNum() {
		return proQnaNum;
	}
	public void setProQnaNum(int proQnaNum) {
		this.proQnaNum = proQnaNum;
	}
	public String getProQnaProName() {
		return proQnaProName;
	}
	public void setProQnaProName(String proQnaProName) {
		this.proQnaProName = proQnaProName;
	}
	public String getProQnaTitle() {
		return proQnaTitle;
	}
	public void setProQnaTitle(String proQnaTitle) {
		this.proQnaTitle = proQnaTitle;
	}
	public String getProQnaContent() {
		return proQnaContent;
	}
	public void setProQnaContent(String proQnaContent) {
		this.proQnaContent = proQnaContent;
	}
	public String getProQnaUserName() {
		return proQnaUserName;
	}
	public void setProQnaUserName(String proQnaUserName) {
		this.proQnaUserName = proQnaUserName;
	}

	public Date getProQnaDate() {
		return proQnaDate;
	}
	public void setProQnaDate(Date proQnaDate) {
		this.proQnaDate = proQnaDate;
	}
	public String getProQnaUserId() {
		return proQnaUserId;
	}
	public void setProQnaUserId(String proQnaUserId) {
		this.proQnaUserId = proQnaUserId;
	}
	public String getProQnaAnswer() {
		return proQnaAnswer;
	}
	public void setProQnaAnswer(String proQnaAnswer) {
		this.proQnaAnswer = proQnaAnswer;
	}
	public int getProQnaSecret() {
		return proQnaSecret;
	}
	public void setProQnaSecret(int proQnaSecret) {
		this.proQnaSecret = proQnaSecret;
	}
	
}
