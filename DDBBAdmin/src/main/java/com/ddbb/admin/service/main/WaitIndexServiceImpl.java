package com.ddbb.admin.service.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerQuestionDAO;
import com.ddbb.admin.DAO.MainBannerDAO;
import com.ddbb.admin.DAO.OrderSimpleListDAO;
import com.ddbb.admin.DAO.ProductQnaDAO;

@Service
public class WaitIndexServiceImpl implements MainService{

	@Autowired
	CustomerQuestionDAO questionDAO;
	@Autowired
	ProductQnaDAO productQnaDAO;
	@Autowired
	OrderSimpleListDAO orderDAO;
	
	@Override
	public void execute(Model model) {

		model.addAttribute("questionCount", questionDAO.questionNoAnswerCount());
		model.addAttribute("productCount", productQnaDAO.productNoAnswerCount());
		model.addAttribute("orderCount", orderDAO.orderWaitCount());

	}

}
