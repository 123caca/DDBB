package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductReviewDAO;

@Service
public class ProductReviewModifyServiceImpl implements ProductService {

	@Autowired
	ProductReviewDAO reviewDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");

		Double proReviewOrderNum = Double.parseDouble(re.getParameter("proReviewOrderNum"));
		String proReviewProName = re.getParameter("proReviewProName");
		
		model.addAttribute("productReviewModify", reviewDAO.productReviewModify(proReviewOrderNum, proReviewProName));

	}

}
