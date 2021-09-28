package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.ProductDAO;

@Service
public class ProductAllListServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String proSort=re.getParameter("proSort");
		String proCategory=re.getParameter("proCategory");
		String proSearch=re.getParameter("proSearch");
		
		String sortSQL="", searchSQL="";
		
		// 정렬, 검색 SQL
		if (proSort == "")
			proSort = null;
		if (proCategory == "")
			proCategory = null;
		
		if (proSort == null && proCategory == null) {
			// 정렬, 검색 파라미터값이 없는 경우
			sortSQL = "";
			searchSQL = "";
		} else if (proSort != null && proCategory == null) {
			// 정렬 파라미터 값은 있고, 검색 파라미터값은 없는 경우
			if (proSort.equals("1"))
				sortSQL =  " ORDER BY proSales DESC";
			else if (proSort.equals("2"))
				sortSQL = " ORDER BY proName";
			else if (proSort.equals("3"))
				sortSQL = " ORDER BY proPrice ASC";
			else if (proSort.equals("4"))
				sortSQL = " ORDER BY proPrice DESC";
			searchSQL = "";
		} else if (proSort == null && proCategory != null) {
			// 정렬 파라미터 값은 없고, 검색 파라미터값은 있는 경우
			sortSQL = "";
			searchSQL = " WHERE " + proCategory + " LIKE '%" + proSearch + "%'";
		} else {
			// 정렬, 검색 파라미터값이 있는 경우
			if (proSort.equals("1"))
				sortSQL = " ORDER BY proSales DESC";
			else if (proSort.equals("2"))
				sortSQL = " ORDER BY proName";
			else if (proSort.equals("3"))
				sortSQL = " ORDER BY proPrice ASC";
			else if (proSort.equals("4"))
				sortSQL = " ORDER BY proPrice DESC";
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

		model.addAttribute("productList", productDAO.productAllList(sortSQL, searchSQL, startNum, endNum));
		model.addAttribute("productCount", productDAO.productCount(searchSQL));
		
	}
}
