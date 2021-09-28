package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartRequest;

import com.ddbb.admin.DAO.ProductQnaDAO;
import com.ddbb.admin.DTO.ProductQnaDTO;

@Service
public class ProductQnaAnswerFnServiceImpl implements ProductService {
	
	@Autowired
	private ProductQnaDAO qnaDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		
		String proQnaNum = re.getParameter("proQnaNum");
		String proQnaAnswer = re.getParameter("proQnaAnswer");
		
		qnaDAO.productQnaAnswerFn(proQnaAnswer, proQnaNum);
	}
}

