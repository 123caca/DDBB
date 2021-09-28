package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddbb.client.DAO.OrderDAO;
import com.ddbb.client.DAO.ProductReviewDAO;
import org.springframework.ui.Model;

@Service
public class ProductReviewDeleteServiceImpl implements ProductService {

	@Autowired
	ProductReviewDAO reviewDAO;
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");

		Double proReviewOrderNum = Double.parseDouble(re.getParameter("proReviewOrderNum"));
		String proReviewProName = re.getParameter("proReviewProName");
		
		reviewDAO.productReviewDelete(proReviewOrderNum, proReviewProName);
		orderDAO.reviewDel(proReviewOrderNum, proReviewProName);

	}

}
