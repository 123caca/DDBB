package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.OrderSimpleListDAO;

@Service
public class OrderSimpleModifyServiceImpl implements ProductService {
	
	@Autowired
	private OrderSimpleListDAO simpleDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String orderProNumber = re.getParameter("orderProNumber");
		String orderTracking = re.getParameter("orderTracking");
		
		if (orderTracking == null)
			orderTracking = "noChk";
		
		if (orderTracking.equals("chk"))
			simpleDAO.orderModify(orderProNumber);
		
	}
}

