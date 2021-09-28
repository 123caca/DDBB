package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerFaqDAO;

@Service
public class CustomerFaqSearchServiceImpl implements CustomerService{

	@Autowired
	CustomerFaqDAO faqDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String faqOption = re.getParameter("faqOption");
		String faqSearch = re.getParameter("faqSearch");
		
		model.addAttribute("faqSearch", faqSearch);
		model.addAttribute("faqOption", faqOption);
		model.addAttribute("faqAllList", faqDAO.faqSearch(faqSearch, faqOption));
		
	}

}
