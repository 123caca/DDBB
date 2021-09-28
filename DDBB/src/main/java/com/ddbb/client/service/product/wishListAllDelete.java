package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.WishListDAO;
import com.ddbb.client.DTO.UserDTO;
@Service
public class wishListAllDelete implements ProductService{

	@Autowired
	WishListDAO wishListDAO;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String userId = userDTO.getUserId();
		
		wishListDAO.cartAllDelete( userId);
	}

}
