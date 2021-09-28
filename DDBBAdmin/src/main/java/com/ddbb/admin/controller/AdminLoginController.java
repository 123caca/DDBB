package com.ddbb.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddbb.admin.DTO.AdminUserDTO;
import com.ddbb.admin.service.login.adminLoginServiceImpl;
import com.ddbb.admin.service.main.WaitIndexServiceImpl;

@Controller
public class AdminLoginController {

	// LoginServiceImpl
	@Autowired
	private adminLoginServiceImpl adminLoginServiceImpl;
	// index
	@Autowired
	private WaitIndexServiceImpl waitIndexServiceImpl;

	// 메인페이지(관리자 로그인세션 확인 후 페이지 이동 )
	@RequestMapping(value = { "", "index" })
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		AdminUserDTO adminuserDTO = (AdminUserDTO) session.getAttribute("adminuser");
		if (adminuserDTO != null) {
			waitIndexServiceImpl.execute(model);
			return "index";
		} else {
			return "redirect:login";
		}
	}

	// 로그인 페이지
	@RequestMapping(value = "login")
	public String login() {
		return "login/login";
	}

	// 로그인(유저 정보 확인 및 로그인(유저세션))
	@RequestMapping(value = "adminuser_login")
	public String login(HttpServletRequest request, Model model, HttpServletResponse response) {
		model.addAttribute("request", request);
		adminLoginServiceImpl.execute(model);
		HttpSession session = request.getSession();
		AdminUserDTO adminuserDTO = (AdminUserDTO) session.getAttribute("adminuser");
		if (adminuserDTO == null) {
			return "login/login";
		} else {
			return "redirect:index";
		}
	}

	// 로그아웃(유저세션, 쿠키 삭제)
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("adminuser");
		return "redirect:index";
	}
}
