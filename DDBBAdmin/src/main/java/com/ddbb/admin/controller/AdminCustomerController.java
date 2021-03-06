package com.ddbb.admin.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ddbb.admin.service.customer.CustomerEventAddServiceImpl;
import com.ddbb.admin.service.customer.CustomerEventAllListServiceImpl;
import com.ddbb.admin.service.customer.CustomerEventDeleteServiceImpl;
import com.ddbb.admin.service.customer.CustomerEventDetailListServiceImpl;
import com.ddbb.admin.service.customer.CustomerEventModifyServiceImpl;
import com.ddbb.admin.service.customer.CustomerFaqAddServiceImpl;
import com.ddbb.admin.service.customer.CustomerFaqAllListServiceImpl;
import com.ddbb.admin.service.customer.CustomerFaqDeleteServiceImpl;
import com.ddbb.admin.service.customer.CustomerFaqDetailListServiceImpl;
import com.ddbb.admin.service.customer.CustomerFaqModifyServiceImpl;
import com.ddbb.admin.service.customer.CustomerNoticeAddServiceImpl;
import com.ddbb.admin.service.customer.CustomerNoticeAllListServiceImpl;
import com.ddbb.admin.service.customer.CustomerNoticeDeleteServiceImpl;
import com.ddbb.admin.service.customer.CustomerNoticeDetailListServiceImpl;
import com.ddbb.admin.service.customer.CustomerNoticeModifyServiceImpl;
import com.ddbb.admin.service.customer.CustomerQuestionAllListServiceImpl;
import com.ddbb.admin.service.customer.CustomerQuestionAnswerServiceImpl;
import com.ddbb.admin.service.customer.CustomerQuestionDeleteServiceImpl;
import com.ddbb.admin.service.customer.CustomerQuestionDetailListServiceImpl;
import com.ddbb.admin.service.customer.CustomerQuestionNoAnswerServiceImpl;

@Controller
public class AdminCustomerController {

	@Autowired
	private CustomerFaqAllListServiceImpl faqAllList;

	@Autowired
	private CustomerFaqAddServiceImpl faqAdd;

	@Autowired
	private CustomerFaqDeleteServiceImpl faqDel;
	
	@Autowired
	private CustomerFaqModifyServiceImpl faqModify;
	
	@Autowired
	private CustomerFaqDetailListServiceImpl faqDetailList;

	@Autowired
	private CustomerQuestionAllListServiceImpl customerQuestionAllList;

	@Autowired
	private CustomerQuestionDetailListServiceImpl customerQuestionDeatilList;

	@Autowired
	private CustomerQuestionAnswerServiceImpl questionAnswer;

	@Autowired
	private CustomerQuestionDeleteServiceImpl questionDel;
	
	@Autowired
	private CustomerQuestionNoAnswerServiceImpl customerQuestionNoAnswer;

	@Autowired
	private CustomerNoticeAllListServiceImpl noticeAllList;

	@Autowired
	private CustomerNoticeAddServiceImpl noticeAdd;

	@Autowired
	private CustomerNoticeDetailListServiceImpl noticeDetailList;

	@Autowired
	private CustomerNoticeModifyServiceImpl noticeModify;

	@Autowired
	private CustomerNoticeDeleteServiceImpl noticeDel;

	@Autowired
	private CustomerEventAllListServiceImpl eventAllList;

	@Autowired
	private CustomerEventDetailListServiceImpl eventDetailList;
	
	@Autowired
	private CustomerEventAddServiceImpl eventAdd;
	
	@Autowired
	private CustomerEventModifyServiceImpl eventModify;
	
	@Autowired
	private CustomerEventDeleteServiceImpl eventDel;

	// ???????????? ?????? ?????????
	@RequestMapping(value = "faq")
	public String faq(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		faqAllList.execute(model);
		return "customer/faq";
	}

	// ???????????? ?????? ??????
	@RequestMapping(value = "faq_add")
	public String faq_add(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		return "customer/faq_add";
	}

	// ???????????? ?????? ?????? ??????
	@RequestMapping(value = "faq_add_fin", method = RequestMethod.POST)
	public String faq_add_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		faqAdd.execute(model);
		return "redirect:faq";
	}

	// ???????????? ?????? ??????
	@RequestMapping(value = "faq_delete", method = RequestMethod.POST)
	public String faq_delete(HttpServletRequest request,@RequestParam(value = "chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		faqDel.execute(model);
		return "redirect:faq";
	}
	
	//???????????? ?????? ?????? ?????????
	@RequestMapping(value="faq_update")
	public String faq_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		faqDetailList.execute(model);
		return "customer/faq_update";
	}
	
	//???????????? ?????? ?????? ?????????
	@RequestMapping(value="faq_update_fin")
	public String faq_update_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		faqModify.execute(model);
		return "redirect:faq";
	}

	// 1:1 ?????? ?????? ??????
	@RequestMapping(value = "question")
	public String question(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		customerQuestionAllList.execute(model);
		return "customer/question";
	}

	// 1:1 ?????? ?????? ?????????
	@RequestMapping(value = "question_answer")
	public String question_answer(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		customerQuestionDeatilList.execute(model);
		return "customer/question_answer";
	}

	// 1:1 ?????? ??????
	@RequestMapping(value = "question_answer_fin")
	public String question_answer_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		questionAnswer.execute(model);
		return "redirect:question";
	}

	// 1:1 ?????? ??????
	@RequestMapping(value = "question_delete", method = RequestMethod.POST)
	public String question_delete(HttpServletRequest request,@RequestParam(value = "chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		questionDel.execute(model);
		return "redirect:question";
	}
	
	// 1:1 ?????? ????????? ?????? ??????
	@RequestMapping(value = "customerQuestionNoAnswer")
	public String customerQuestionNoAnswer(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		customerQuestionNoAnswer.execute(model);
		return "customer/question";
	}
	

	// ???????????? ?????????
	@RequestMapping(value = "notice")
	public String notice(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		noticeAllList.execute(model);
		return "customer/notice";
	}

	// ???????????? ?????? ?????????
	@RequestMapping(value = "notice_add")
	public String notice_add(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		return "customer/notice_add";
	}

	// ???????????? ?????? ??????
	@RequestMapping(value = "notice_add_fin", method = RequestMethod.POST)
	public String notice_add_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		noticeAdd.execute(model);
		return "redirect:notice";
	}

	// ???????????? ?????? ?????????
	@RequestMapping(value = "notice_update")
	public String notice_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		noticeDetailList.execute(model);
		return "customer/notice_update";
	}

	// ???????????? ?????? ??????
	@RequestMapping(value = "notice_update_fin", method = RequestMethod.POST)
	public String notice_update_fin(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		noticeModify.execute(model);
		return "redirect:notice";
	}

	// ???????????? ??????
	@RequestMapping(value = "notice_delete", method = RequestMethod.POST)
	public String notice_delete(HttpServletRequest request,@RequestParam(value = "chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		noticeDel.execute(model);
		return "redirect:notice";
	}

	// ????????? ?????????
	@RequestMapping(value = "event")
	public String event(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		eventAllList.execute(model);
		return "customer/event";
	}
	
	// ????????? ?????? ?????????
	@RequestMapping(value = "event_update")
	public String event_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("request", request);
		eventDetailList.execute(model);
		return "customer/event_update";
	}

	// ????????? ??????
	@RequestMapping(value = "event_add")
	public String event_add(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		return "customer/event_add";
	}

	// ????????? ?????? ??????
	@RequestMapping(value = "event_add_fin", method = RequestMethod.POST)
	public String event_add_fin(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		String fileTag1 = "cusEventThumbnailImg";
		String fileTag2 = "cusEventContentsImg";
		String filePath1 = "C:\\Users\\PARK SIU\\Programing\\PROJECT\\DDBB\\src\\main\\webapp\\resources\\images\\customer\\event\\thum\\";
		String filePath2 = "C:\\Users\\PARK SIU\\Programing\\PROJECT\\DDBB\\src\\main\\webapp\\resources\\images\\customer\\event\\content\\";
		MultipartFile file1 = mtf.getFile(fileTag1);
		MultipartFile file2 = mtf.getFile(fileTag2);
		String fileName1 = file1.getOriginalFilename();
		String fileName2 = file2.getOriginalFilename();
		try {
			file1.transferTo(new File(filePath1 + fileName1));
			file2.transferTo(new File(filePath2 + fileName2));
		} catch (Exception e) {
			System.out.println("????????? ??????");
		}

		model.addAttribute("fileName1", fileName1);
		model.addAttribute("fileName2", fileName2);
		model.addAttribute("request", request);
		eventAdd.execute(model);
		return "redirect:event";
	}
	
	//????????? ?????? 
	@RequestMapping(value = "event_update_fin", method = RequestMethod.POST)
	public String event_update_fin(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		String fileTag1 = "cusEventThumbnailImg";
		String fileTag2 = "cusEventContentsImg";
		String filePath1 = "C:\\Users\\PARK SIU\\Programing\\PROJECT\\DDBB\\src\\main\\webapp\\resources\\images\\customer\\event\\thum\\";
		String filePath2 = "C:\\Users\\PARK SIU\\Programing\\PROJECT\\DDBB\\src\\main\\webapp\\resources\\images\\customer\\event\\content\\";
		MultipartFile file1 = mtf.getFile(fileTag1);
		MultipartFile file2 = mtf.getFile(fileTag2);
		String fileName1 = file1.getOriginalFilename();
		String fileName2 = file2.getOriginalFilename();
		try {
			file1.transferTo(new File(filePath1 + fileName1));
			file2.transferTo(new File(filePath2 + fileName2));
		} catch (Exception e) {
			System.out.println("????????? ??????");
		}

		model.addAttribute("fileName1", fileName1);
		model.addAttribute("fileName2", fileName2);
		model.addAttribute("request", request);
		eventModify.execute(model);
		return "redirect:event";
	}
	
	//????????? ??????
	@RequestMapping(value = "event_delete", method = RequestMethod.POST)
	public String event_delete(HttpServletRequest request,@RequestParam(value = "chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		model.addAttribute("delete", list);
		eventDel.execute(model);
		return "redirect:event";
	}

}
