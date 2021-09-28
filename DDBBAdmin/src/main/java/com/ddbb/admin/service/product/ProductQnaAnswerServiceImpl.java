package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.ProductQnaDAO;

@Service
public class ProductQnaAnswerServiceImpl implements ProductService {
	
	@Autowired
	private ProductQnaDAO qnaDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String proQnaNum = re.getParameter("proQnaNum");
		
		model.addAttribute("productQnaAnswer", qnaDAO.productQnaAnswer(proQnaNum));
	}
}
