package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerEventDAO;

@Service
public class CustomerEventAllListServiceImpl implements CustomerService{

	@Autowired
	CustomerEventDAO eventDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String eventOption=re.getParameter("eventOption");
		String eventSearch=re.getParameter("eventSearch");
		
		String searchSQL="";
		
		if (eventOption == "")
			eventOption = null;
		
		if (eventOption == null) {
			searchSQL = "";
		} else {
			if (eventOption.equals("1"))
				eventOption = "cusEventTitle";
			searchSQL = " WHERE " + eventOption + " LIKE '%" + eventSearch + "%'";
		}
		
		// 페이징
		String pagingParam = re.getParameter("paging");
		int paging, startNum, endNum;
		if (pagingParam == null || pagingParam == "")
			paging = 0;
		else 
			paging = Integer.parseInt(pagingParam);
		if (paging == 0) {
			startNum = 1;
			endNum = 12;
		} else {
			startNum = (paging - 1) * 12 + 1;
			endNum = paging * 12;
		}

		model.addAttribute("eventAllList", eventDAO.customerEventAllList(searchSQL, startNum, endNum));
		model.addAttribute("eventCount", eventDAO.eventCount(searchSQL));
		
	}

}
