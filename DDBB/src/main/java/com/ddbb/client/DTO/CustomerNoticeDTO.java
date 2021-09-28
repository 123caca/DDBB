package com.ddbb.client.DTO;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerNoticeDTO {
	/*
	 * create table customernotice ( cusnoticenum NUMBER not null, cusnoticetitle
	 * varchar2(50) not null, cusnoticecontent varchar2(500) not null, cusnoticedate
	 * date not null );
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
