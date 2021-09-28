package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerFaqDAO;
import com.ddbb.admin.DTO.CustomerEventDTO;
import com.ddbb.admin.DTO.CustomerFaqDTO;

@Service
public class CustomerFaqModifyServiceImpl implements CustomerService{

	@Autowired
	private CustomerFaqDAO faqDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");
		
		String cusFaqTitle = re.getParameter("cusFaqTitle");
		String cusFaqContent = re.getParameter("cusFaqContent");
		int cusFaqNum= Integer.parseInt(re.getParameter("cusFaqNum"));
		
		CustomerFaqDTO dto = new CustomerFaqDTO();
		dto.setCusFaqTitle(cusFaqTitle);
		dto.setCusFaqContent(cusFaqContent);
		dto.setCusFaqNum(cusFaqNum);
		
		faqDAO.customerFaqModify(dto);
		
		model.addAttribute("faqList",dto);
		
	}

}
