package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerEventDAO;

@Service
public class CustomerEventDetailListServiceImpl implements CustomerService{

	@Autowired
	CustomerEventDAO eventDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");

		int cuseventnum =Integer.parseInt( re.getParameter("cuseventnum"));
		
		model.addAttribute("cusEventTitle", eventDAO.customerEventDetailList(cuseventnum));
		
	}

}
