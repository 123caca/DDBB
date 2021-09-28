package com.ddbb.admin.service.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerQuestionDAO;

@Service
public class CustomerQuestionDeleteServiceImpl implements CustomerService{

	@Autowired
	private CustomerQuestionDAO questionDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		List<String> questionDel = (List<String>) map.get("delete");
		for(int i = 0; i < questionDel.size(); i++) {
			questionDAO.customerQuestionDelete(questionDel.get(i));
		}
	}
}
