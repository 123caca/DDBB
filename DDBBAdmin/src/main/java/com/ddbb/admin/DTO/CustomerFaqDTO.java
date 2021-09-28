package com.ddbb.admin.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerFaqDTO {
	private int cusFaqNum;
	private String cusFaqTitle;
	private String cusFaqContent;
	
	public int getCusFaqNum() {
		return cusFaqNum;
	}
	public void setCusFaqNum(int cusFaqNum) {
		this.cusFaqNum = cusFaqNum;
	}
	public String getCusFaqTitle() {
		return cusFaqTitle;
	}
	public void setCusFaqTitle(String cusFaqTitle) {
		this.cusFaqTitle = cusFaqTitle;
	}
	public String getCusFaqContent() {
		return cusFaqContent;
	}
	public void setCusFaqContent(String cusFaqContent) {
		this.cusFaqContent = cusFaqContent;
	}
}
