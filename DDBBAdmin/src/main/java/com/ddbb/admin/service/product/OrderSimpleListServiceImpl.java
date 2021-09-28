package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.OrderSimpleListDAO;

@Service
public class OrderSimpleListServiceImpl implements ProductService {

	@Autowired
	private OrderSimpleListDAO simpleDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		String orderCategory=re.getParameter("orderCategory");
		String orderSearch=re.getParameter("orderSearch");
		
		String searchSQL="";
		
		// 검색 SQL
		if (orderCategory == "")
			orderCategory = null;
		
		if (orderCategory == null) {
			// 검색 파라미터값이 없는 경우
			searchSQL = "";
		} else {
			// 검색 파라미터값이 있는 경우
			searchSQL = " WHERE " + orderCategory + " LIKE '%" + orderSearch + "%'";
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
		
		model.addAttribute("orderSimpleList", simpleDAO.orderSimpleList(searchSQL, startNum, endNum));
		model.addAttribute("orderSimpleCount", simpleDAO.orderSimpleCount(searchSQL));
		
	}
}
