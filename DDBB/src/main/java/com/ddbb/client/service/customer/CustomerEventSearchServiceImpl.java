package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerEventDAO;

@Service
public class CustomerEventSearchServiceImpl implements CustomerService {

	@Autowired
	CustomerEventDAO eventDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String eventOption = re.getParameter("eventOption");
		String eventSearch = re.getParameter("eventSearch");
		
		model.addAttribute("eventSearch", eventSearch);
		model.addAttribute("eventOption", eventOption);
		model.addAttribute("eventAllList", eventDAO);		
	}

}
