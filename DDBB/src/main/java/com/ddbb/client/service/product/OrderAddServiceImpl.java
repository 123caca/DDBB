package com.ddbb.client.service.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.CartDAO;
import com.ddbb.client.DAO.OrderDAO;
import com.ddbb.client.DAO.ProductDAO;
import com.ddbb.client.DTO.CartDTO;
import com.ddbb.client.DTO.OrderDTO;
import com.ddbb.client.DTO.ProductDTO;
import com.ddbb.client.DTO.UserDTO;

@Service
public class OrderAddServiceImpl implements ProductService {

	@Autowired
	OrderDAO orderDAO;
	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		String orderUserId = userDTO.getUserId();
		String orderUserName = userDTO.getUserName();

		String orderProNumber = re.getParameter("orderProNumber");
		int orderTracking = Integer.parseInt(re.getParameter("orderTracking"));

		String proName = re.getParameter("proName");		// 상품 페이지에서 결제 시 상품명
		String orderSimSelectCost = re.getParameter("orderSimSelectCost");
		int proAccount = Integer.parseInt(orderSimSelectCost);
		OrderDTO dto = new OrderDTO();

		List<String> cartList = (List<String>) map.get("cartList");
		
		if (cartList == null) {
			// 상품페이지에서 결제 할 때
			ProductDTO productDTO = productDAO.productSearch(proName);
			dto.setOrderProNumber(orderProNumber);
			dto.setOrderUserId(orderUserId);
			dto.setOrderUserName(orderUserName);
			dto.setOrderProImg(productDTO.getProImg());
			dto.setOrderProName(productDTO.getProName());
			dto.setOrderProPrice(productDTO.getProPrice());
			dto.setOrderProAccount(proAccount / productDTO.getProPrice());
			dto.setOrderTracking(orderTracking);
			orderDAO.orderAdd(dto);
		} else {
			// 장바구니로 결제 할 때
			for(int i = 0; i < cartList.size(); i++) {
				CartDTO cartDTO = cartDAO.cartSearch(cartList.get(i), orderUserId);
				dto.setOrderProNumber(orderProNumber);
				dto.setOrderUserId(orderUserId);
				dto.setOrderUserName(orderUserName);
				dto.setOrderProImg(cartDTO.getProImg());
				dto.setOrderProName(cartDTO.getProName());
				dto.setOrderProPrice(cartDTO.getProPrice());
				dto.setOrderProAccount(cartDTO.getAddAccount());
				dto.setOrderTracking(orderTracking);
				orderDAO.orderAdd(dto);
				cartDAO.cartDelete(cartDTO.getProName(), orderUserId);
			}
			
		}

	}

}
