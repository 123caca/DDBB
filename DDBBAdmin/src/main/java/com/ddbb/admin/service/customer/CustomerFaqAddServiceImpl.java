package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerFaqDAO;
import com.ddbb.admin.DTO.CustomerFaqDTO;

@Service
public class CustomerFaqAddServiceImpl implements CustomerService{

	@Autowired
	CustomerFaqDAO faqDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String faqTitle = re.getParameter("faqTitle");
		String faqContent = re.getParameter("faqContent");
		
		CustomerFaqDTO dto = new CustomerFaqDTO();
		dto.setCusFaqTitle(faqTitle);
		dto.setCusFaqContent(faqContent);
		
		model.addAttribute("faqAdd",dto);
		faqDAO.customerFaqAdd(dto);
		
	}

}
