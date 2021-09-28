package com.ddbb.client.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CustomerNoticeDAO;

@Service
public class CustomerNoticeSearchServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerNoticeDAO noticeDAO;

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String noticeOption = re.getParameter("noticeOption");
		String noticeSearch = re.getParameter("noticeSearch");
		
		model.addAttribute("noticeSearch", noticeSearch);
		model.addAttribute("noticeOption", noticeOption);
		model.addAttribute("noticeAllList", noticeDAO.noticeSearch(noticeSearch, noticeOption));
	}
}
