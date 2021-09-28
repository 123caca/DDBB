package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerQuestionDAO;
import com.ddbb.client.DTO.UserDTO;

@Service
public class CustomerQuestionDetailListServiceImpl implements CustomerService {

	@Autowired
	CustomerQuestionDAO questionDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String cusQuestionNum = re.getParameter("cusQuestionNum");
		
		model.addAttribute("cusQuestionNum", questionDAO.customerQuestionDetailList(cusQuestionNum));
	}

}
