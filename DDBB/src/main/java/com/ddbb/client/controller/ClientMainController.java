package com.ddbb.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddbb.client.service.main.AllSearchMainServiceImpl;

@Controller
public class ClientMainController {
	@Autowired
	private AllSearchMainServiceImpl AllSearchMainServiceImpl;

	@RequestMapping(value = "guide")
	public String guide() {
		return "guide";
	}

	@RequestMapping(value = "header")
	public String header() {
		return "layout/header";
	}

	// 전체 검색
	@RequestMapping(value = "search")
	public String search(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		AllSearchMainServiceImpl.execute(model);
		return "search";
	}

	// 개인정보보호방침
	@RequestMapping(value = "statement")
	public String statement() {
		return "mypage/statement";
	}

	// 이용약관
	@RequestMapping(value = "user_terms")
	public String user_terms() {
		return "mypage/user_terms";
	}

}
