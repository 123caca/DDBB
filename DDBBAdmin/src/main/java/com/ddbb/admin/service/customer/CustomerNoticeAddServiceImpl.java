package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerNoticeDAO;
import com.ddbb.admin.DTO.CustomerNoticeDTO;

@Service
public class CustomerNoticeAddServiceImpl implements CustomerService {

	@Autowired
	CustomerNoticeDAO noticeDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");

		String noticeTitle = re.getParameter("noticeTitle");
		String noticeContent = re.getParameter("noticeContent");

		CustomerNoticeDTO dto = new CustomerNoticeDTO();
		dto.setCusNoticeTitle(noticeTitle);
		dto.setCusNoticeContent(noticeContent);

		model.addAttribute("noticeAdd", dto);
		noticeDAO.customerNoticeAdd(dto);

	}

}
