package com.ddbb.client.service.product;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductReviewDAO;
import com.ddbb.client.DTO.ProductReviewDTO;

@Service
public class ProductReviewModifyfnServiceImpl implements ProductService {

	@Autowired
	ProductReviewDAO reviewDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		Double proReviewOrderNum = Double.parseDouble(re.getParameter("proReviewOrderNum"));
		String proReviewProName = re.getParameter("proReviewProName");
		int proReviewScore = Integer.parseInt(re.getParameter("proReviewScore"));
		String proReviewContent = re.getParameter("proReviewContent");

		// 이미지 출력
		String proReviewImg = (String)map.get("fileName");
		if (proReviewImg.equals(""))
			proReviewImg = "resources/images/product/review/noImg.png";
		else
			proReviewImg = "resources/images/product/review/" + proReviewImg;
		
		ProductReviewDTO dto = new ProductReviewDTO();
		dto.setProReviewOrderNum(proReviewOrderNum);
		dto.setProReviewProName(proReviewProName);
		dto.setProReviewScore(proReviewScore);
		dto.setProReviewImg(proReviewImg);
		dto.setProReviewContent(proReviewContent);
		
		reviewDAO.productReviewModifyFn(dto);

	}

}
