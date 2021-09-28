package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductQnaDAO;

@Service
public class ProductQnaDetailListServiceImpl implements ProductService {

	@Autowired
	ProductQnaDAO qnaDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String proQnaNum = re.getParameter("proQnaNum");
		
		model.addAttribute("productQnaDetailList", qnaDAO.productQnaDetailList(proQnaNum));

	}

}
