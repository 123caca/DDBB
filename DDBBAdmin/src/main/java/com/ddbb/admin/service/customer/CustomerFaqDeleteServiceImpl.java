package com.ddbb.admin.service.customer;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerFaqDAO;


@Service
public class CustomerFaqDeleteServiceImpl implements CustomerService{
	@Autowired
	private CustomerFaqDAO faqDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		List<String> faqDelete = (List<String>) map.get("delete");
		for(int i = 0; i < faqDelete.size(); i++) {
			faqDAO.customerFaqDelete(faqDelete.get(i));
		}
	}
}
