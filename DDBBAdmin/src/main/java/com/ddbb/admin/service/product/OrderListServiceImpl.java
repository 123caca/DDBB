package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.OrderDAO;
import com.ddbb.admin.DAO.UserDAO;


@Service
public class OrderListServiceImpl implements ProductService {
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String orderProNumber = re.getParameter("orderProNumber");
		String orderUserId = re.getParameter("orderUserId");

		model.addAttribute("orderUser", userDAO.userDetailList(orderUserId));
		model.addAttribute("orderList", orderDAO.orderList(orderProNumber));
		
	}
}
