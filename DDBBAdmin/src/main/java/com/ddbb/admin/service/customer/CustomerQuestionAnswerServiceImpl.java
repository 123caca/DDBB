package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerQuestionDAO;
import com.ddbb.admin.DTO.CustomerQuestionDTO;

@Service
public class CustomerQuestionAnswerServiceImpl implements CustomerService {

	@Autowired
	private CustomerQuestionDAO questionDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");

		String cusQuestionAnswer = re.getParameter("answer_content");
		String cusQuestionNum = re.getParameter("cusQuestionNum");
		
		CustomerQuestionDTO dto = new CustomerQuestionDTO();
		dto.setCusQuestionAnswer(cusQuestionAnswer);
		dto.setCusQuestionNum(Integer.parseInt(cusQuestionNum));

		model.addAttribute("questionAnswer", dto);
		questionDAO.customerQuestionAnswer(dto);
	}

}
