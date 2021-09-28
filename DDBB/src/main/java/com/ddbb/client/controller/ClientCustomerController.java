package com.ddbb.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddbb.client.service.customer.CustomerEventAllListServiceImpl;
import com.ddbb.client.service.customer.CustomerEventDetailListServiceImpl;
import com.ddbb.client.service.customer.CustomerFaqAllListServiceImpl;
import com.ddbb.client.service.customer.CustomerNoticeDetailListServiceImpl;
import com.ddbb.client.service.customer.CustomerNoticeMainListServiceImpl;
import com.ddbb.client.service.customer.CustomerNottceAllListServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionAddServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionAllListServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionDeleteServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionDetailListServiceImpl;
import com.ddbb.client.service.customer.CustomerQuestionModifyServiceImpl;

@Controller
public class ClientCustomerController {
	
	@Autowired
	private CustomerFaqAllListServiceImpl faqAllList;
	
	@Autowired
	private CustomerQuestionAllListServiceImpl questionAllList;
	
	@Autowired
	private CustomerQuestionDetailListServiceImpl questionDetailList;
	
	@Autowired
	private CustomerQuestionAddServiceImpl questionAdd;

//	@Autowired
//	private CustomerQuestionModifyServiceImpl questionModifyList;
	
	@Autowired
	private CustomerQuestionDeleteServiceImpl questionDel;
	
	@Autowired
	private CustomerQuestionModifyServiceImpl questionModify;

	@Autowired
	private CustomerNottceAllListServiceImpl noticeAllList;
	
	@Autowired
	private CustomerNoticeDetailListServiceImpl noticeDetailList;
	
	@Autowired
	private CustomerNoticeMainListServiceImpl noticeMainList;
	
	@Autowired
	private CustomerEventAllListServiceImpl eventAllList;
	
	@Autowired
	private CustomerEventDetailListServiceImpl eventDetailList;
	

	//자주하는 질문 
	@RequestMapping(value="faq")
	public String faq(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		faqAllList.execute(model);
		return "customer/faq";
	}

	//1:1문의 페이지
	@RequestMapping(value="question")
	public String question(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		questionAllList.execute(model);
		return "customer/question";
	}
	
	//1:1문의 상세 페이지
	@RequestMapping(value="question_con")
	public String question_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		questionDetailList.execute(model);
		return "customer/question_con";
	}
	
	//1:1문의 등록 페이지
	@RequestMapping(value="question_write")
	public String question_write(HttpServletRequest request) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		return "customer/question_write";
	}
	
	//1:1문의 등록 체크
	@RequestMapping(value="question_add_chk", method = RequestMethod.POST)
	public String question_add_chk(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		questionAdd.execute(model);
		return "redirect:question";
	}
	
	//1:1문의 수정 페이지
	@RequestMapping(value="question_update")
	public String question_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		questionDetailList.execute(model);
		return "customer/question_update";
	}
	
	//1:1 문의 수정 체크
	@RequestMapping(value="question_update_fin")
	public String question_update_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		questionModify.execute(model);
		return "redirect:question";
	}
	
	// 1:1문의 삭제
	@RequestMapping(value="question_del")
	public String question_del(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("user") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		questionDel.execute(model);
		return "redirect:question";
	}
	
	//공지사항 페이지
	@RequestMapping(value="notice")
	public String notice(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		noticeAllList.execute(model);
		return "customer/notice";
	}
	
	//공지사항 상세 페이지
	@RequestMapping(value="notice_con")
	public String notice_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		noticeDetailList.execute(model);
		return "customer/notice_con";
	}
	
	
	// 공지사항 인덱스 출력
	
	
	//이벤트 페이지
	@RequestMapping(value="event")
	public String event(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		eventAllList.execute(model);
		return "customer/event"; 
	}
	
	
	// 이벤트 상세 페이지
	@RequestMapping(value="event_con")
	public String event_con(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		eventDetailList.execute(model);
		return "customer/event_con"; 
	}
	
	
}
