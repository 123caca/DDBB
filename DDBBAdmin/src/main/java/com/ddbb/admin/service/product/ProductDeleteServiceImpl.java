package com.ddbb.admin.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.ProductDAO;
import com.ddbb.admin.DTO.ProductDTO;

@Service
public class ProductDeleteServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		
		List<String> proDelete = (List<String>) map.get("delete");
		for(int i = 0; i < proDelete.size(); i++) {
			productDAO.productDelete(proDelete.get(i));
		}
	}
}
