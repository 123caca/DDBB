package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.ProductQnaDAO;
import com.ddbb.client.DTO.ProductQnaDTO;
import com.ddbb.client.DTO.UserDTO;

@Service
public class ProductQnaAddServiceImpl implements ProductService {

	@Autowired
	ProductQnaDAO qnaDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		
		String proQnaUserId = userDTO.getUserId();
		String proQnaUserName = userDTO.getUserName();
		String proQnaProName = re.getParameter("proQnaProName");
		String proQnaTitle = re.getParameter("proQnaTitle");
		String proQnaContent = re.getParameter("proQnaContent");
		
		ProductQnaDTO dto = new ProductQnaDTO();
		dto.setProQnaProName(proQnaProName);
		dto.setProQnaTitle(proQnaTitle);
		dto.setProQnaContent(proQnaContent);
		dto.setProQnaUserName(proQnaUserName);
		dto.setProQnaUserId(proQnaUserId);
		
		qnaDAO.productQnaAdd(dto);
	}

}
