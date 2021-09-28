package com.ddbb.client.service.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CartDAO;
import com.ddbb.client.DTO.CartDTO;
import com.ddbb.client.DTO.UserDTO;


@Service
public class CartAddServiceImpl implements ProductService {

	@Autowired
	private CartDAO cartDAO;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String userId = userDTO.getUserId();
		
		String proName = re.getParameter("proName");
		String proPrice = re.getParameter("proPrice");
		String proImg = re.getParameter("proImg");
		String addAccount = re.getParameter("addAccount");
		
		CartDTO dto = new CartDTO();
		dto.setUserId(userId);
		dto.setProName(proName);
		dto.setProPrice(Integer.parseInt(proPrice));
		dto.setProImg(proImg);
		dto.setAddAccount(Integer.parseInt(addAccount));

		if (cartDAO.cartChk(proName,userId) == 0)
			cartDAO.cartAdd(dto);

	}

}
