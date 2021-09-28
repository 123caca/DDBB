package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.OrderSimpleListDAO;
import com.ddbb.client.DTO.UserDTO;


@Service
public class OrderSimpleListServiceImpl implements ProductService {
	
	@Autowired
	private OrderSimpleListDAO simpleDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		String startDay = re.getParameter("startDay");
		String endDay = re.getParameter("endDay");
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String userId = userDTO.getUserId();
		
		String searchSQL="";
		
		// 기간별 주문 조회
		if (startDay == null || startDay == "")
			searchSQL = " WHERE orderUserId='" + userId + "'";
		else 
			searchSQL = " WHERE orderDate >= '" + startDay + "' AND orderDate <= '" + endDay + "' AND orderUserId='" + userId + "'";
		
		
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
		
		model.addAttribute("orderSimpleList", simpleDAO.orderSimpleList(searchSQL, startNum, endNum));
		model.addAttribute("orderSimpleCount", simpleDAO.orderSimpleCount(searchSQL));

	}

}
