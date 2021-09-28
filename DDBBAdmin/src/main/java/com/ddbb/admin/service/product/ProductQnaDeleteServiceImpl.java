package com.ddbb.admin.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.ProductDAO;
import com.ddbb.admin.DAO.ProductQnaDAO;
import com.ddbb.admin.DTO.ProductDTO;

@Service
public class ProductQnaDeleteServiceImpl implements ProductService {

	@Autowired
	private ProductQnaDAO qnaDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		List<String> proQnaDelete = (List<String>) map.get("delete");
		for(int i = 0; i < proQnaDelete.size(); i++) {
			qnaDAO.productQnaDelete(proQnaDelete.get(i));
		}
	}
}
