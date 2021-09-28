package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerQuestionDAO;
import com.ddbb.admin.DTO.CustomerFaqDTO;

@Service
public class CustomerQuestionAllListServiceImpl implements CustomerService {

	@Autowired
	CustomerQuestionDAO customerQuestionDAO;

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
				questionOption = "cusQuestionUserId";
			else if (questionOption.equals("4"))
				questionOption = "cusQuestionUserName";
			else if (questionOption.equals("5"))
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

		model.addAttribute("questionAllList", customerQuestionDAO.customerQuestionAllList(searchSQL, startNum, endNum));
		model.addAttribute("questionCount", customerQuestionDAO.questionCount(searchSQL));
		
	}

}
