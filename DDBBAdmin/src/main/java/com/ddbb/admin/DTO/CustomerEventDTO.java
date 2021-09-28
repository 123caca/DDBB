package com.ddbb.admin.DTO;

import java.sql.Date;

public class CustomerEventDTO {

	/*
	 * create table customerevent (
    cuseventtitle varchar2(50),
    cuseventcontentsimg varchar2(100),
    cuseventthumbnailimg varchar2(100),
    cuseventstartdate date,
    cuseventenddate date,
    cuseventdate date
	);
	 */
	
	private int cuseventnum;
	private String cusEventTitle;
	private String cusEventContentsImg;
	private String cusEventThumbnailImg;
	private String cusEventStartDate;
	private String cusEventEndDate;
	private String cusEventDate;
	
	public int getCuseventnum() {
		return cuseventnum;
	}
	public void setCuseventnum(int cuseventnum) {
		this.cuseventnum = cuseventnum;
	}
	public String getCusEventTitle() {
		return cusEventTitle;
	}
	public void setCusEventTitle(String cusEventTitle) {
		this.cusEventTitle = cusEventTitle;
	}
	public String getCusEventContentsImg() {
		return cusEventContentsImg;
	}
	public void setCusEventContentsImg(String cusEventContentsImg) {
		this.cusEventContentsImg = cusEventContentsImg;
	}
	public String getCusEventThumbnailImg() {
		return cusEventThumbnailImg;
	}
	public void setCusEventThumbnailImg(String cusEventThumbnailImg) {
		this.cusEventThumbnailImg = cusEventThumbnailImg;
	}
	public String getCusEventStartDate() {
		return cusEventStartDate;
	}
	public void setCusEventStartDate(String cusEventStartDate) {
		this.cusEventStartDate = cusEventStartDate;
	}
	public String getCusEventEndDate() {
		return cusEventEndDate;
	}
	public void setCusEventEndDate(String cusEventEndDate) {
		this.cusEventEndDate = cusEventEndDate;
	}
	public String getCusEventDate() {
		return cusEventDate;
	}
	public void setCusEventDate(String cusEventDate) {
		this.cusEventDate = cusEventDate;
	}
	
	
	
}
