package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.ProductDAO;

@Service
public class ProductQnaNoAnswerServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String proName = re.getParameter("proName");
		
		model.addAttribute("productModify", productDAO.productModify(proName));
	}
}
