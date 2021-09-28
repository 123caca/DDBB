package com.ddbb.client.service.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.MainDAO;

@Service
public class AllSearchMainServiceImpl implements MainService{
	@Autowired
	private MainDAO maindao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String search=(String)re.getParameter("search");
		model.addAttribute("productSearchList",maindao.productSearch(search));
		model.addAttribute("productSearchListTotal",maindao.productSearchTotal(search));
		model.addAttribute("customerFaqSearchList",maindao.customerFaqSearch(search));
		model.addAttribute("customerFaqSearchListTotal",maindao.customerFaqSearchTotal(search));
		model.addAttribute("customerQuestionSearchList",maindao.customerQuestionSearch(search));
		model.addAttribute("customerQuestionSearchListTotal",maindao.customerQuestionSearchTotal(search));
		model.addAttribute("customerNoticeSearchList",maindao.customerNoticeSearch(search));
		model.addAttribute("customerNoticeSearchListTotal",maindao.customerNoticeSearchTotal(search));
		model.addAttribute("customerEventSearchList",maindao.customerEventSearch(search));
		model.addAttribute("customerEventSearchListTotal",maindao.customerEventSearchTotal(search));
		
	}

}
