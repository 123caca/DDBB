package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerQuestionDAO;
import com.ddbb.client.DTO.CustomerQuestionDTO;
import com.ddbb.client.DTO.UserDTO;

@Service
public class CustomerQuestionAddServiceImpl implements CustomerService {

	@Autowired
	private CustomerQuestionDAO questionDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
	    
		String questionTitle  = re.getParameter("question_title");
	    String questionContent  = re.getParameter("question_content");
		
		CustomerQuestionDTO dto = new CustomerQuestionDTO();
		dto.setCusQuestionTitle(questionTitle);
		dto.setCusQuestionContent(questionContent);
		dto.setCusQuestionUserId(userDTO.getUserId());
		dto.setCusQuestionUserName(userDTO.getUserName());

		model.addAttribute("productModify", dto);
		questionDAO.customerQuestionAdd(dto);

	}

}
