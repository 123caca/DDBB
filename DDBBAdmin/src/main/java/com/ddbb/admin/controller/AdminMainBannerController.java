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

import com.ddbb.admin.service.main.MainBannerAddServiceImpl;
import com.ddbb.admin.service.main.MainBannerDeleteServiceImpl;
import com.ddbb.admin.service.main.MainBannerDetailListServiceImpl;
import com.ddbb.admin.service.main.MainBannerModifyServiceImpl;
import com.ddbb.admin.service.main.MainBannerServiceAllListImpl;

@Controller
public class AdminMainBannerController {
	
	@Autowired
	private MainBannerServiceAllListImpl bannerList;
	
	@Autowired
	private MainBannerAddServiceImpl bannerAdd;
	
	@Autowired
	private MainBannerDetailListServiceImpl bannerDetailList;
	
	@Autowired
	private MainBannerModifyServiceImpl bannerModify;
	
	@Autowired
	private MainBannerDeleteServiceImpl bannerDel;
	
	//슬라이드 배너 페이지
	@RequestMapping(value = "banner")
	public String banner(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		bannerList.execute(model);
		return "main/banner";
	}
	
	//슬라이드 배너 추가 페이지
	@RequestMapping(value = "banner_add")
	public String banner_add(HttpServletRequest request) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		
		return "main/banner_add";
	}

	//슬라이드 배너 추가
	@RequestMapping(value = "banner_add_fin", method = RequestMethod.POST)
	public String event_add_fin(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		
		String fileTag = "mainBannerImg";
		String filePath = "resources\\images\\main\\banner";
		String uploadPath = request.getSession().getServletContext().getRealPath(filePath).replace("DDBBAdmin", "DDBB");
		MultipartFile file = mtf.getFile(fileTag); 
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File(uploadPath + "\\" + fileName));
		} catch (Exception e) {
		}
		
		model.addAttribute("fileName", fileName);
		model.addAttribute("request", request);
		bannerAdd.execute(model);
		return "redirect:banner";
	}
	
	
	//슬라이드 배너 수정 페이지
	@RequestMapping(value = "banner_update")
	public String banner_update(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		
		model.addAttribute("request", request);
		bannerDetailList.execute(model);
		return "main/banner_update";
	}
	
	//슬라이드 배너 수정 완료
	@RequestMapping(value="banner_update_fin")
	public String banner_update_fin(MultipartHttpServletRequest mtf, HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		
		String fileTag = "mainBannerImg";
		String filePath = "resources\\images\\main\\banner";
		String uploadPath = request.getSession().getServletContext().getRealPath(filePath).replace("DDBBAdmin", "DDBB");
		MultipartFile file = mtf.getFile(fileTag); 
		String fileName = file.getOriginalFilename();
		try {
			file.transferTo(new File(uploadPath + "\\" + fileName));
		} catch (Exception e) {
		}
		
		model.addAttribute("fileName", fileName);
		model.addAttribute("request", request);
		bannerModify.execute(model);
		return "redirect:banner";
		
	}
	
	//슬라이드 배너 삭제
	@RequestMapping(value="banner_delete", method = RequestMethod.POST)
	public String banner_delete(HttpServletRequest request,@RequestParam(value="chBox") List<String> list, Model model) {
		if (request.getSession().getAttribute("adminuser") == null)
			return "redirect:login";
		
		model.addAttribute("delete", list);
		bannerDel.execute(model);
		return "redirect:banner";
	}

}
