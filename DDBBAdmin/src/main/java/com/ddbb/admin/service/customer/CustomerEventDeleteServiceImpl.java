package com.ddbb.admin.service.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerEventDAO;

@Service
public class CustomerEventDeleteServiceImpl implements CustomerService{
	@Autowired
	CustomerEventDAO eventDAO;
	
	@Override
	public void execute(Model model) {
	Map<String, Object> map = model.asMap();
		
		List<String> eventDelete = (List<String>) map.get("delete");
		for(int i = 0; i < eventDelete.size(); i++) {
			eventDAO.customerEventDelete(eventDelete.get(i));
		}
		
	}
	
}
