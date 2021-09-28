package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerNoticeDAO;

@Service
public class CustomerNoticeDetailListServiceImpl implements CustomerService{

	@Autowired
	CustomerNoticeDAO noticeDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");

		String cusNoticeNum = re.getParameter("cusNoticeNum");
		
		model.addAttribute("cusNoticeNum", noticeDAO.customerNoticeDetailList(cusNoticeNum));
		
	}

}
