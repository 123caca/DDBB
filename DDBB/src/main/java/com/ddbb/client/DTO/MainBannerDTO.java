package com.ddbb.client.DTO;

import org.springframework.stereotype.Repository;

@Repository
public class MainBannerDTO {
	
	/*
	 * create table mainbanner(
    mainbannertitle varchar2(50) not null,
    mainbannerimg varchar2(100) not null,
    mainbannerlink varchar2(100) not null,
    mainbannersort number primary key
);
	 */
	
	
	private String mainBannerTitle;
	private String mainBannerImg;
	private String mainBannerLink;
	private int mainBannerSort;
	
	public String getMainBannerTitle() {
		return mainBannerTitle;
	}
	public void setMainBannerTitle(String mainBannerTitle) {
		this.mainBannerTitle = mainBannerTitle;
	}
	public String getMainBannerImg() {
		return mainBannerImg;
	}
	public void setMainBannerImg(String mainBannerImg) {
		this.mainBannerImg = mainBannerImg;
	}
	public String getMainBannerLink() {
		return mainBannerLink;
	}
	public void setMainBannerLink(String mainBannerLink) {
		this.mainBannerLink = mainBannerLink;
	}
	public int getMainBannerSort() {
		return mainBannerSort;
	}
	public void setMainBannerSort(int mainBannerSort) {
		this.mainBannerSort = mainBannerSort;
	}
	
	

}
