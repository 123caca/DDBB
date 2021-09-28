package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ddbb.client.DAO.OrderDAO;
import com.ddbb.client.DAO.ProductReviewDAO;
import com.ddbb.client.DTO.ProductReviewDTO;
import com.ddbb.client.DTO.UserDTO;

@Service
public class ProductReviewAddServiceImpl implements ProductService {

	@Autowired
	ProductReviewDAO reviewDAO;
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		Double proReviewOrderNum = Double.parseDouble(re.getParameter("proReviewOrderNum"));
		String proReviewProName = re.getParameter("proReviewProName");
		String proReviewUserId = userDTO.getUserId();
		String proReviewUserName = userDTO.getUserName();
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
		dto.setProReviewUserId(proReviewUserId);
		dto.setProReviewUserName(proReviewUserName);
		dto.setProReviewScore(proReviewScore);
		dto.setProReviewImg(proReviewImg);
		dto.setProReviewContent(proReviewContent);
		
		reviewDAO.productReviewAdd(dto);
		orderDAO.reviewChk(proReviewOrderNum, proReviewProName);
		
	}

}
