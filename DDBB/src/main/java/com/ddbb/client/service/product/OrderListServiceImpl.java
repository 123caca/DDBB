package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.OrderDAO;

@Service
public class OrderListServiceImpl implements ProductService {
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String orderProNumber = re.getParameter("orderProNumber");

		String searchSQL = "";
		if (orderProNumber == null || orderProNumber == "")
			searchSQL = "";
		else 
			searchSQL = " WHERE orderProNumber='" + orderProNumber + "'";
		
		model.addAttribute("orderList", orderDAO.orderList(searchSQL));
		model.addAttribute("orderCount", orderDAO.orderCount(searchSQL));

	}

}
