package com.ddbb.client.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.OrderSimpleListDAO;
import com.ddbb.client.DTO.OrderSimpleListDTO;
import com.ddbb.client.DTO.UserDTO;


@Service
public class OrderSimpleAddServiceImpl implements ProductService {

	@Autowired
	OrderSimpleListDAO simpleDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String orderUserId = userDTO.getUserId();
		String orderUserName = userDTO.getUserName();
		
		String orderProNumber = re.getParameter("orderProNumber");
		String orderProImg = re.getParameter("orderProImg");
		String orderProName = re.getParameter("orderProName");
		int orderTracking = Integer.parseInt(re.getParameter("orderTracking"));
		int orderSimSelectCost = Integer.parseInt(re.getParameter("orderSimSelectCost"));

		OrderSimpleListDTO dto = new OrderSimpleListDTO();
		dto.setOrderProNumber(orderProNumber);
		dto.setOrderUserId(orderUserId);
		dto.setOrderUserName(orderUserName);
		dto.setOrderProImg(orderProImg);
		dto.setOrderProName(orderProName);
		dto.setOrderTracking(orderTracking);
		dto.setOrderSimTotalCost(orderSimSelectCost);

		simpleDAO.orderSimpleAdd(dto);
		
	}

}
