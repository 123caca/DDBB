package com.ddbb.client.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddbb.client.DTO.UserDTO;
import com.ddbb.client.service.login.AutoLoginServiceImpl;
import com.ddbb.client.service.login.IdCheckServiceImpl;
import com.ddbb.client.service.login.UserIDFindServiceImpl;
import com.ddbb.client.service.login.UserJoinServiceImpl;
import com.ddbb.client.service.login.UserLoginServiceImpl;
import com.ddbb.client.service.login.UserPwdFindServiceImpl;
import com.ddbb.client.service.login.UserPwdUpdateServiceImpl;
import com.ddbb.client.service.main.MainBannerServiceImpl;
import com.ddbb.client.service.main.MainEventServiceImpl;
import com.ddbb.client.service.main.MainNoticeServiceImpl;
import com.ddbb.client.service.main.MainProductServiceImpl;

@Controller
public class ClientLoginController {


	// MainServiceImpl
	@Autowired
	private MainNoticeServiceImpl cusNoticeMainList;
	@Autowired
	private MainEventServiceImpl cusEventMainList;
	@Autowired
	private MainProductServiceImpl proMainList;
	@Autowired
	private MainBannerServiceImpl mainBannerList;
	
	// LoginServiceImpl
	@Autowired
	private IdCheckServiceImpl IdCheckServiceImpl;
	@Autowired
	private UserJoinServiceImpl UserJoinServiceImpl;
	@Autowired
	private UserLoginServiceImpl UserLoginServiceImpl;
	@Autowired
	private UserIDFindServiceImpl UserIDFindServiceImpl;
	@Autowired
	private UserPwdFindServiceImpl UserPwdFindServiceImpl;
	@Autowired
	private UserPwdUpdateServiceImpl UserPwdUpdateServiceImpl;
	@Autowired
	private AutoLoginServiceImpl AutoLoginServiceImpl;

	// 메인페이지(쿠키 확인 후 자동로그인)
	@RequestMapping(value = { "/", "index" })
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("request", request);
		mainBannerList.execute(model);
		cusNoticeMainList.execute(model);
		cusEventMainList.execute(model);
		proMainList.execute(model);
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginCookie")) {
					loginCookie = cookie;
					String userID = loginCookie.getValue();
					model.addAttribute("userID", userID);
					AutoLoginServiceImpl.execute(model);
				}
			}
		}
		return "index";
	}

	// 로그인 페이지
	@RequestMapping(value = "login")
	public String login() {
		return "login/login";
	}

	// 회원가입 약관동의 페이지
	@RequestMapping(value = "join_agree")
	public String join_agree() {
		return "login/join_agree";
	}

	// 회원가입 정보 입력페이지
	@RequestMapping(value = "join_input")
	public String join_input() {
		return "login/join_input";
	}

	// 회원가입 아이디 중복 체크(ajax)
	@RequestMapping(value = "idchk")
	@ResponseBody
	public String idchk(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		IdCheckServiceImpl.execute(model);
		Map<String, Object> map = model.asMap();
		return Integer.toString((Integer) map.get("userIdchk"));
	}

	// 회원가입 완료 페이지(DB 테이블에 데이터 추가)
	@RequestMapping(value = "join_fin")
	public String join_fin(HttpServletRequest request, Model model, HttpServletResponse response) {
		model.addAttribute("request", request);
		UserJoinServiceImpl.execute(model);
		return "login/join_fin";
	}

	// 로그인(유저 정보 확인 및 로그인(유저세션), 자동로그인 체크 여부 확인 후 쿠키 생성 )
	@RequestMapping(value = "user_login")
	public String user_login(HttpServletRequest request, Model model, HttpServletResponse response) {
		model.addAttribute("request", request);
		// 아이디, 비밀번로 확인 및 유저 세션 생성 
		UserLoginServiceImpl.execute(model);
		// 세션 확인 후 페이지 이동
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("user");
		if (userDTO == null) {
			return "login/login";
		} else {
			// 자동로그인 체크 시 쿠키 생성
			if (request.getParameterValues("autologin") != null) {
				Cookie cookie = new Cookie("loginCookie", userDTO.getUserId());
				cookie.setPath("/");
				cookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(cookie);
			} 
			return "redirect:index";
		}
	}

	// 아이디 찾기 페이지
	@RequestMapping(value = "find_id")
	public String find_id() {
		return "login/find_id";
	}

	// 아이디 찾기 결과 페이지
	@RequestMapping(value = "find_id_result")
	public String find_id_result(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		UserIDFindServiceImpl.execute(model);
		return "login/find_id_result";
	}

	// 비밀번호 찾기 페이지
	@RequestMapping(value = "find_pw")
	public String find_pw() {
		return "login/find_pw";
	}

	// 비밀번호 찾기 결과 페이지
	@RequestMapping(value = "find_pw_result")
	public String find_pw_result(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		UserPwdFindServiceImpl.execute(model);
		return "login/find_pw_result";
	}

	// 비밀번호 찾기 완료 후 비밀번호 변경
	@RequestMapping(value = "find_pw_update")
	public String find_pw_update(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		UserPwdUpdateServiceImpl.execute(model);
		return "login/login";
	}

	// 로그아웃(유저세션, 쿠키 삭제)
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, Model model, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		session.removeAttribute("user");

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginCookie")) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}

		return "redirect:index";
	}

}
