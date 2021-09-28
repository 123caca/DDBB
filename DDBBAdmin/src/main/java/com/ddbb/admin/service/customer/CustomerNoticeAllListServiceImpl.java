package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerNoticeDAO;

@Service
public class CustomerNoticeAllListServiceImpl implements CustomerService{

	@Autowired
	CustomerNoticeDAO noticeDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");

		String noticeOption=re.getParameter("noticeOption");
		String noticeSearch=re.getParameter("noticeSearch");
		
		String searchSQL="";
		
		if (noticeOption == "")
			noticeOption = null;
		
		if (noticeOption == null) {
			searchSQL = "";
		} else {
			if (noticeOption.equals("1"))
				noticeOption = "cusNoticeTitle";
			else if (noticeOption.equals("2"))
				noticeOption = "cusNoticeContent";
			else if (noticeOption.equals("3"))
				noticeOption = "(cusNoticeTitle||cusNoticeContent)";
			searchSQL = " WHERE " + noticeOption + " LIKE '%" + noticeSearch + "%'";
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

		model.addAttribute("noticeAllList", noticeDAO.customerNoticeAllList(searchSQL, startNum, endNum));
		model.addAttribute("noticeCount", noticeDAO.noticeCount(searchSQL));
		

	}

}
