package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.ProductDAO;
import com.ddbb.admin.DAO.ProductQnaDAO;

@Service
public class ProductQnaAllListServiceImpl implements ProductService {
	
	@Autowired
	private ProductQnaDAO productQnaDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String proCategory=re.getParameter("proCategory");
		String proSearch=re.getParameter("proSearch");
		
		String searchSQL="";
		
		// 정렬, 검색 SQL
		if (proCategory == "")
			proCategory = null;
		
		if (proCategory == null) {
			// 정렬, 검색 파라미터값이 없는 경우
			searchSQL = "";
		} else {
			// 정렬, 검색 파라미터값이 있는 경우
			if (proCategory.equals("1"))
				proCategory = "proQnaTitle";
			else if (proCategory.equals("2"))
				proCategory = "proQnaContent";
			else if (proCategory.equals("3"))
				proCategory = "proQnaUserId";
			else if (proCategory.equals("4"))
				proCategory = "proQnaUserName";
			else if (proCategory.equals("5"))
				proCategory = "(proQnaTitle || proQnaContent)";
			searchSQL = " WHERE " + proCategory + " LIKE '%" + proSearch + "%'";
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
			endNum = 10;
		} else {
			startNum = (paging - 1) * 10 + 1;
			endNum = paging * 10;
		}
		
		model.addAttribute("productList", productQnaDAO.productAllList(searchSQL, startNum, endNum));
		model.addAttribute("productCount", productQnaDAO.productCount(searchSQL));
		
	}
}
