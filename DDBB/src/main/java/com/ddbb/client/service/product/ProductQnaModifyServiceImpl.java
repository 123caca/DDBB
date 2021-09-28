package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddbb.client.DAO.ProductQnaDAO;
import org.springframework.ui.Model;

@Service
public class ProductQnaModifyServiceImpl implements ProductService {

	@Autowired
	ProductQnaDAO qnaDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String proQnaNum = re.getParameter("proQnaNum");
		
		model.addAttribute("productQnaModify", qnaDAO.productQnaModify(proQnaNum));

	}

}
