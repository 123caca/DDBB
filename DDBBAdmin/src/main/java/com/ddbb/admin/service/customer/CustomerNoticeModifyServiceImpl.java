package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerNoticeDAO;
import com.ddbb.admin.DTO.CustomerNoticeDTO;

@Service
public class CustomerNoticeModifyServiceImpl implements CustomerService{

	@Autowired
	CustomerNoticeDAO noticeDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");

		String cusNoticeNum = (String)re.getParameter("noticeNum");
		String cusNoticeTitle = re.getParameter("noticeTitle");
		String cusNoticeContent = re.getParameter("noticeContent");
		
		CustomerNoticeDTO dto = new CustomerNoticeDTO();
		dto.setCusNoticeTitle(cusNoticeTitle);
		dto.setCusNoticeContent(cusNoticeContent);
		dto.setCusNoticeNum(Integer.parseInt(cusNoticeNum));
		
		noticeDAO.customerNoticeModify(dto);
		
	}

}
