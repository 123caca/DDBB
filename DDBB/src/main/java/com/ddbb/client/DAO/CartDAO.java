package com.ddbb.client.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CartDTO;
import com.ddbb.client.DTO.ProductDTO;

@Repository
public class CartDAO {
	private JdbcTemplate template;
	
	public CartDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 장바구니 전체 출력
	public ArrayList<CartDTO> allList(String userId) {
		String sql = "SELECT * FROM cart WHERE userId='"+userId+"'"; 
		
		ArrayList<CartDTO> list = null;

		try {
			list = (ArrayList<CartDTO>)template.query(sql, new BeanPropertyRowMapper<CartDTO>(CartDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	// 장바구니 상품 확인
	public int cartChk(String proName,String userId) {
		String sql = "SELECT COUNT(*) FROM cart WHERE proName='" + proName + "' and userId='"+userId+"'";

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 장바구니 추가
	public void cartAdd(final CartDTO dto) {
		String sql = "INSERT INTO cart(userId, proName, proPrice, proImg, addAccount) "
				+ "values(?,?,?,?,?)";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getUserId());
				ps.setString(2, dto.getProName());
				ps.setInt(3, dto.getProPrice());
				ps.setString(4, dto.getProImg());
				ps.setInt(5, dto.getAddAccount());
			}
		}); 
	}

	// 장바구니 삭제
	public void cartDelete(String proName, String userId) {
		String sql = "DELETE FROM cart "
				+ "WHERE proName='" + proName + "' "
				+ "AND userId='" + userId + "'";
		
		template.update(sql);
	}
	
	// 주문조회로 넘길 장바구니 데이터 검색
	public CartDTO cartSearch(String proName, String userId) {
		String sql = "SELECT * FROM cart" 
				+ " WHERE proName='" + proName + "' " 
				+ " AND userId='" + userId + "'";
		
		CartDTO dto = null;

		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<CartDTO>(CartDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return dto;
	}
}
