package com.ddbb.admin.DTO;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerNoticeDTO {
	/*
	 * 
	create table customernotice (
		    cusnoticenum number,
		    cusnoticetitle varchar2(50),
		    cusnoticecontent varchar2(500),
		    cusnoticedate date
		);
	 */ 
	
	private int cusNoticeNum;
	private String cusNoticeTitle;
	private String cusNoticeContent;
	private Date cusNoticeDate;
	public int getCusNoticeNum() {
		return cusNoticeNum;
	}
	public void setCusNoticeNum(int cusNoticeNum) {
		this.cusNoticeNum = cusNoticeNum;
	}
	public String getCusNoticeTitle() {
		return cusNoticeTitle;
	}
	public void setCusNoticeTitle(String cusNoticeTitle) {
		this.cusNoticeTitle = cusNoticeTitle;
	}
	public String getCusNoticeContent() {
		return cusNoticeContent;
	}
	public void setCusNoticeContent(String cusNoticeContent) {
		this.cusNoticeContent = cusNoticeContent;
	}
	public Date getCusNoticeDate() {
		return cusNoticeDate;
	}
	public void setCusNoticeDate(Date cusNoticeDate) {
		this.cusNoticeDate = cusNoticeDate;
	}
	

}
