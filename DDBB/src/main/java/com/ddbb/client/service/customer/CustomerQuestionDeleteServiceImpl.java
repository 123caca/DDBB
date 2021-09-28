package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerQuestionDAO;

@Service
public class CustomerQuestionDeleteServiceImpl implements CustomerService {

	@Autowired
	CustomerQuestionDAO questionDAO;
	
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String cusQuestionNums = re.getParameter("cusQuestionNum");
		int cusQuestionNum=Integer.parseInt(cusQuestionNums);
		
		questionDAO.customerQuestionDelete(cusQuestionNum);
		
	}

}
