package com.ddbb.client.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerEventDTO {

	/*
	create table customerevent (
    cuseventtitle varchar2(50) not null,
    cuseventcontentsimg varchar2(100) not null,
    cuseventthumbnailimg varchar2(100) not null,
    cuseventstartdate number not null, 
    cuseventenddate number not null,
    cuseventdate date not null );
	 */

	private int cuseventnum;
	private String cusEventTitle;
	private String cusEventContentsImg;
	private String cusEventThumbnailImg;
	private String cusEventstartdate;
	private String cusEventenddate;
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

	public void setCusEvenTtitle(String cusEventTitle) {
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



	public String getCusEventstartdate() {
		return cusEventstartdate;
	}

	public void setCusEventstartdate(String cusEventstartdate) {
		this.cusEventstartdate = cusEventstartdate;
	}

	public String getCusEventenddate() {
		return cusEventenddate;
	}

	public void setCusEventenddate(String cusEventenddate) {
		this.cusEventenddate = cusEventenddate;
	}

	public void setCusEventTitle(String cusEventTitle) {
		this.cusEventTitle = cusEventTitle;
	}

	public String getCusEventDate() {
		return cusEventDate;
	}

	public void setCusEventDate(String cusEventDate) {
		this.cusEventDate = cusEventDate;
	}

}
