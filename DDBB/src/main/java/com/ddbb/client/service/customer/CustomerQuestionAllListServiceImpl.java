package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerQuestionDAO;

@Service
public class CustomerQuestionAllListServiceImpl implements CustomerService {

	@Autowired
	CustomerQuestionDAO questionDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String questionOption=re.getParameter("questionOption");
		String questionSearch=re.getParameter("questionSearch");
		
		String searchSQL="";
		
		if (questionOption == "")
			questionOption = null;
		
		if (questionOption == null) {
			searchSQL = "";
		} else {
			if (questionOption.equals("1"))
				questionOption = "cusQuestionTitle";
			else if (questionOption.equals("2"))
				questionOption = "cusQuestionContent";
			else if (questionOption.equals("3"))
				questionOption = "(cusQuestionTitle||cusQuestionContent)";
			searchSQL = " WHERE " + questionOption + " LIKE '%" + questionSearch + "%'";
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
			endNum = 10;
		} else {
			startNum = (paging - 1) * 10 + 1;
			endNum = paging * 10;
		}

		model.addAttribute("questionAllList", questionDAO.customerQuestionAllList(searchSQL, startNum, endNum));
		model.addAttribute("questionCount", questionDAO.questionCount(searchSQL));
	}

}
