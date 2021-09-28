package com.ddbb.client.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.WishListDTO;

@Repository
public class WishListDAO {
	private JdbcTemplate template;
	
	public WishListDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 찜목록 전체 출력
	public ArrayList<WishListDTO> allList(String userId) {
		String sql = "SELECT * FROM wishList WHERE userId='"+userId+"'"; 
		
		ArrayList<WishListDTO> list = null;

		try {
			list = (ArrayList<WishListDTO>)template.query(sql, new BeanPropertyRowMapper<WishListDTO>(WishListDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return list;
	}
	
	// 찜목록 상품 확인
	public int wishListChk(String proName,String userId) {
		String sql = "SELECT COUNT(*) FROM wishList WHERE proName='" + proName + "' and userId='"+userId+"'";

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 찜목록 추가
	public void wishListAdd(final WishListDTO dto) {
		String sql = "INSERT INTO wishList(userId, proName, proPrice, proImg) "
				+ "values(?,?,?,?)";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getUserId());
				ps.setString(2, dto.getProName());
				ps.setInt(3, dto.getProPrice());
				ps.setString(4, dto.getProImg());
			}
		}); 
	}

	// 찜목록 삭제
	public void cartDelete(String proName, String userId) {
		String sql = "DELETE FROM wishList "
				+ "WHERE proName='" + proName + "' "
				+ "AND userId='" + userId + "'";
		
		template.update(sql);
	}
	// 찜목록 선택 삭제
	public void WishListDeleteChkBox(String userId,String wishProName) {
		String sql = "DELETE FROM wishList "
				+ "WHERE proName='" + wishProName + "' "
				+ "AND userId='" + userId + "'";
		template.update(sql);
	}
	// 찜목록 전체 삭제
	public void cartAllDelete(String userId) {
		String sql = "DELETE FROM wishList "
				+ "WHERE userId='" + userId + "'";
		template.update(sql);
	}
	

}
