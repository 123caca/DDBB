package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductReviewDAO;


@Service
public class ProductReviewListServiceImpl implements ProductService {

	@Autowired
	ProductReviewDAO reviewDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String proName = re.getParameter("proName");
		String proSort = re.getParameter("proSort");
		
		String sortSQL="";
		String listSQL = "";
		listSQL = " WHERE proReviewProName='" + proName + "'";
		
		// 정렬 SQL
		if (proName == "")
			proName = null;
		if (proSort == "")
			proSort = null;
		
		if (proSort == null) {
			sortSQL = " ORDER BY proReviewNum DESC";
		} else {
			if (proSort.equals("1"))
				sortSQL = " ORDER BY proReviewScore DESC";
			else if (proSort.equals("2"))
				sortSQL = " ORDER BY proReviewScore";
			else if (proSort.equals("3"))
				sortSQL = " ORDER BY proReviewDate";
		}
		listSQL += sortSQL;

		// 페이징
		String pagingParam = re.getParameter("pagingReview");
		int paging, startNum, endNum;
		if (pagingParam == null || pagingParam == "")
			paging = 0;
		else 
			paging = Integer.parseInt(pagingParam);
		if (paging == 0) {
			startNum = 1;
			endNum = 5;
		} else {
			startNum = (paging - 1) * 5 + 1;
			endNum = paging * 5;
		}
		
		model.addAttribute("productReviewList", reviewDAO.productReviewAllList(listSQL, startNum, endNum));
		model.addAttribute("productReviewCount", reviewDAO.productCount(listSQL));

	}

}
