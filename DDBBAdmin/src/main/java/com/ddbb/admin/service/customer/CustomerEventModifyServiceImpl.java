package com.ddbb.admin.service.customer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.CustomerEventDAO;
import com.ddbb.admin.DTO.CustomerEventDTO;

@Service
public class CustomerEventModifyServiceImpl implements CustomerService {
		
	@Autowired
	CustomerEventDAO eventDAO;
		
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest) map.get("request");
		
		String cusEventTitle = re.getParameter("cusEventTitle");
		String cusEventStartDate = re.getParameter("cusEventStartDate");
		String cusEventEndDate = re.getParameter("cusEventEndDate");
		int cuseventnum =Integer.parseInt( re.getParameter("cuseventnum"));
		// 이미지 출력
		String proReviewImg1 = (String) map.get("fileName1");
		proReviewImg1 = "resources/images/customer/event/thum/" + proReviewImg1;
	
		String proReviewImg2 = (String) map.get("fileName2");
		proReviewImg2 = "resources/images/customer/event/content/" + proReviewImg2;
			
		CustomerEventDTO dto = new CustomerEventDTO();
		dto.setCuseventnum(cuseventnum);
		dto.setCusEventTitle(cusEventTitle);
		dto.setCusEventStartDate(cusEventStartDate);
		dto.setCusEventEndDate(cusEventEndDate);
		dto.setCusEventThumbnailImg(proReviewImg1);
		dto.setCusEventContentsImg(proReviewImg2);
		
		eventDAO.customerEventModify(dto);

	}


}
