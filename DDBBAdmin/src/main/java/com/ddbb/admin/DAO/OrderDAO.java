package com.ddbb.admin.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.OrderDTO;

@Repository
public class OrderDAO {
	private JdbcTemplate template;
	
	public OrderDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 주문조회 상세페이지 출력
	public ArrayList<OrderDTO> orderList(String orderProNumber) {
		String sql = "SELECT * FROM buyOrder WHERE orderProNumber=" + orderProNumber;
		
		ArrayList<OrderDTO> list = null;
	
		try {
			list = (ArrayList<OrderDTO>)template.query(sql, new BeanPropertyRowMapper<OrderDTO>(OrderDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
