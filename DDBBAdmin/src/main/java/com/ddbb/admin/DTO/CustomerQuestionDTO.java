package com.ddbb.admin.DTO;

import java.sql.Date;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerQuestionDTO {
	private int cusQuestionNum;
	private String cusQuestionTitle;
	private String cusQuestionContent;
	private String cusQuestionUserId;
	private String cusQuestionUserName;
	private Date cusQuestionDate;
	private String cusQuestionAnswer;
	private int cusQuestionSecret;

	public int getCusQuestionNum() {
		return cusQuestionNum;
	}

	public void setCusQuestionNum(int cusQuestionNum) {
		this.cusQuestionNum = cusQuestionNum;
	}

	public String getCusQuestionTitle() {
		return cusQuestionTitle;
	}

	public void setCusQuestionTitle(String cusQuestionTitle) {
		this.cusQuestionTitle = cusQuestionTitle;
	}

	public String getCusQuestionContent() {
		return cusQuestionContent;
	}

	public void setCusQuestionContent(String cusQuestionContent) {
		this.cusQuestionContent = cusQuestionContent;
	}

	public String getCusQuestionUserId() {
		return cusQuestionUserId;
	}

	public void setCusQuestionUserId(String cusQuestionUserId) {
		this.cusQuestionUserId = cusQuestionUserId;
	}

	public String getCusQuestionUserName() {
		return cusQuestionUserName;
	}

	public void setCusQuestionUserName(String cusQuestionUserName) {
		this.cusQuestionUserName = cusQuestionUserName;
	}

	public Date getCusQuestionDate() {
		return cusQuestionDate;
	}

	public void setCusQuestionDate(Date cusQuestionDate) {
		this.cusQuestionDate = cusQuestionDate;
	}

	public String getCusQuestionAnswer() {
		return cusQuestionAnswer;
	}

	public void setCusQuestionAnswer(String cusQuestionAnswer) {
		this.cusQuestionAnswer = cusQuestionAnswer;
	}

	public int getCusQuestionSecret() {
		return cusQuestionSecret;
	}

	public void setCusQuestionSecret(int cusQuestionSecret) {
		this.cusQuestionSecret = cusQuestionSecret;
	}

}
