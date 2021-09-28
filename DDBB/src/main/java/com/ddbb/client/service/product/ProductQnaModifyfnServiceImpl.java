package com.ddbb.client.service.product;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddbb.client.DAO.ProductQnaDAO;
import com.ddbb.client.DTO.ProductQnaDTO;

import org.springframework.ui.Model;

@Service
public class ProductQnaModifyfnServiceImpl implements ProductService {

	@Autowired
	ProductQnaDAO qnaDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		int proQnaNum = Integer.parseInt(re.getParameter("proQnaNum"));
		String proQnaUserName = re.getParameter("proQnaUserName");
		String proQnaTitle = re.getParameter("proQnaTitle");
		String proQnaContent = re.getParameter("proQnaContent");
		
		ProductQnaDTO dto = new ProductQnaDTO();
		dto.setProQnaNum(proQnaNum);
		dto.setProQnaUserName(proQnaUserName);
		dto.setProQnaTitle(proQnaTitle);
		dto.setProQnaContent(proQnaContent);
		
		qnaDAO.productQnaModifyFn(dto);

	}

}
