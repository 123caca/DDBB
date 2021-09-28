package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerQuestionDAO;

@Service
public class CustomerQuestionNoAnswerServiceImpl implements CustomerService{

	@Autowired
	private CustomerQuestionDAO customerQuestionDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");

		String cusQuestionNum = re.getParameter("cusNoticeNum");
		
		model.addAttribute("questionList", customerQuestionDAO.customerQuestionDetailList(cusQuestionNum));
		
	}

}
