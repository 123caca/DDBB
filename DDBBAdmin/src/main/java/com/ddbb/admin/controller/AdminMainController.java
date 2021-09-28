package com.ddbb.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddbb.admin.service.main.AllSearchMainServiceImpl;

@Controller
public class AdminMainController {
	@Autowired
	private AllSearchMainServiceImpl AllSearchMainServiceImpl;

	
	@RequestMapping(value="header")
	public String header() {
		return "layout/header";
	}
	// 전체 검색
	@RequestMapping(value="search")
	public String search(Model model,HttpServletRequest request) {

		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request",request);
		AllSearchMainServiceImpl.execute(model);
		return "search";
	}
	
}
