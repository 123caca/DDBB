package com.ddbb.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddbb.admin.service.member.AdminUserListDetailServiceImpl;
import com.ddbb.admin.service.member.AdminUserListServiceImpl;
import com.ddbb.admin.service.member.AdminUserUpdateServiceImpl;
import com.ddbb.admin.service.member.AdminUserAddServiceImpl;
import com.ddbb.admin.service.member.AdminUserdeleteServiceImpl;
import com.ddbb.admin.service.member.overlapCheckServiceImpl;
import com.ddbb.admin.service.member.UserListDetailServiceImpl;
import com.ddbb.admin.service.member.UserListServiceImpl;


@Controller
public class adminMemberManagementController {
	
	// LoginServiceImpl
	@Autowired
	private UserListServiceImpl UserListServiceImpl;
	@Autowired
	private UserListDetailServiceImpl UserListDetailServiceImpl;
	@Autowired
	private AdminUserListServiceImpl AdminUserListServiceImpll;
	@Autowired
	private AdminUserListDetailServiceImpl AdminUserListDetailServiceImpl;
	@Autowired
	private AdminUserUpdateServiceImpl AdminUserUpdateServiceImpl;
	@Autowired
	private AdminUserdeleteServiceImpl AdminUserdeleteServiceImpl;
	@Autowired
	private AdminUserAddServiceImpl AdminUserAddServiceImpl;
	@Autowired
	private overlapCheckServiceImpl overlapCheckServiceImpl;
	
	// 회원정보 페이지
	@RequestMapping(value = "member")
	public String member(Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		UserListServiceImpl.execute(model);
		return "user/member";
	}
	// 회원정보 상세 페이지
	@RequestMapping(value = "member_con")
	public String member_con(Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		UserListDetailServiceImpl.execute(model);
		return "user/member_con";
	}
	// 관리자 정보 페이지
	@RequestMapping(value = "admin")
	public String admin(Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		AdminUserListServiceImpll.execute(model);
		return "user/admin";
	}
	// 관리자 정보 수정 페이지
	@RequestMapping(value = "admin_update")
	public String admin_update(Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		AdminUserListDetailServiceImpl.execute(model);
		return "user/admin_update";
	}
	// 관리자 정보 수정 완료 후 페이지이동
	@RequestMapping(value = "admin_update_result")
	public String admin_update_result(Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		AdminUserUpdateServiceImpl.execute(model);
		return "redirect:admin";
	}
	
	// 관리자 정보 삭제  
	@RequestMapping(value = "admin_delete")
	public String admin_delete(HttpServletRequest request,@RequestParam(value="chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		AdminUserdeleteServiceImpl.execute(model);
		return "redirect:admin";
	}
	// 관리자 아이디 생성 페이지
	@RequestMapping(value = "join")
	public String join(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		return "user/join";
	}
	// 관리자 아이디 생성
	@RequestMapping(value = "admin_add")
	public String admin_add(Model model,HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		AdminUserAddServiceImpl.execute(model);
		return "redirect:admin";
	}
	//  중복 체크(ajax)
		@RequestMapping(value = "overlapchk")
		@ResponseBody
		public String overlapchk(HttpServletRequest request, Model model) {
			model.addAttribute("request", request);
			overlapCheckServiceImpl.execute(model);
			Map<String, Object> map = model.asMap();
			int overlapchk = (Integer) map.get("overlapchk");
			return Integer.toString(overlapchk);
		}
}
