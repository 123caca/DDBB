package com.ddbb.admin.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartRequest;

import com.ddbb.admin.DAO.ProductDAO;
import com.ddbb.admin.DTO.ProductDTO;

@Service
public class ProductModifyFnServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");

		String proCategory = re.getParameter("proCategory");
		if (proCategory.equals("1"))  
			proCategory = "식빵 · 식사용빵";
		else if (proCategory.equals("2")) 
			proCategory = "간식용빵";
		else if (proCategory.equals("3"))
			proCategory = "조리빵";
		else if (proCategory.equals("4")) 
			proCategory = "샌드위치";
		else if (proCategory.equals("5")) 
			proCategory = "케이크";
		
		String proName = re.getParameter("proName");
		String proPrice = re.getParameter("proPrice");

		// 이미지 출력
		String proImg = "resources/images/product/" + (String)map.get("fileName1");
		String proContentImg = "resources/images/product/content/" + (String)map.get("fileName2");
		
		ProductDTO dto = new ProductDTO();
		dto.setProCategory(proCategory);
		dto.setProName(proName);
		dto.setProPrice(Integer.parseInt(proPrice));
		dto.setProImg(proImg);
		dto.setProContentImg(proContentImg);
		
		productDAO.productModifyFn(dto);
	}
}

