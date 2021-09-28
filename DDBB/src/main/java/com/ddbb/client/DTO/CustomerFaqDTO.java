package com.ddbb.client.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerFaqDTO {
	
	/*
	 * CREATE TABLE customerfaq ( cusfaqtitle VARCHAR2(50), cusfaqcontent  VARCHAR2(500));
	 */

	private int cusfaqnum;
	private String cusFaqTitle;
	private String cusFaqContent;
	
	
	public int getCusfaqnum() {
		return cusfaqnum;
	}
	public void setCusfaqnum(int cusfaqnum) {
		this.cusfaqnum = cusfaqnum;
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
