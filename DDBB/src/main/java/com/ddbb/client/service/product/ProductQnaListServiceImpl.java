package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductQnaDAO;

@Service
public class ProductQnaListServiceImpl implements ProductService {

	@Autowired
	ProductQnaDAO qnaDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String proName = re.getParameter("proName");
		
		String listSQL="";
		
		// 정렬 SQL
		if (proName == "")
			proName = null;
		
		if (proName == null) {
			listSQL = "";
		} else {
			listSQL = " WHERE proQnaProName='" + proName + "' ORDER BY proQnaNum DESC";
		}
		

		// 페이징
		String pagingParam = re.getParameter("paging");
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
		
		model.addAttribute("productQnaList", qnaDAO.productQnaAllList(listSQL, startNum, endNum));
		model.addAttribute("productQnaCount", qnaDAO.productCount(listSQL));

	}

}
