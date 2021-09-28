package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerQuestionDAO;
import com.ddbb.client.DTO.CustomerQuestionDTO;

@Service
public class CustomerQuestionModifyServiceImpl implements CustomerService{

	@Autowired
	CustomerQuestionDAO questionDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String questionTitle  = re.getParameter("question_title");
	    String questionContent  = re.getParameter("question_content");
	    String questionNum = re.getParameter("cusQuestionNum");
	    
	    CustomerQuestionDTO dto = new CustomerQuestionDTO();
		dto.setCusQuestionTitle(questionTitle);
		dto.setCusQuestionContent(questionContent);
		dto.setCusQuestionNum(Integer.parseInt(questionNum));
		
		model.addAttribute("productModify", dto);
		questionDAO.customerQuestionModifyFin(dto);
	}
	
	

}
