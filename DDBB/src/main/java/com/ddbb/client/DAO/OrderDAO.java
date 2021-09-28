package com.ddbb.client.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.OrderDTO;

@Repository
public class OrderDAO {
	private JdbcTemplate template;
	
	public OrderDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 주문조회 상세페이지 출력
	public ArrayList<OrderDTO> orderList(String searchSQL) {
		String sql = "SELECT * FROM buyOrder" + searchSQL;
		
		ArrayList<OrderDTO> list = null;
	
		try {
			list = (ArrayList<OrderDTO>)template.query(sql, new BeanPropertyRowMapper<OrderDTO>(OrderDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 총 게시글 갯수 출력
	public int orderCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM buyOrder " + searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 주문조회 데이터 추가
	public void orderAdd(final OrderDTO dto) {
		String sql = "INSERT INTO buyOrder "
				+ "VALUES(?,?,?,TO_char(SYSDATE, 'yyyy-mm-dd'),"
				+ "?,?,?,?,?,0)";
		
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getOrderProNumber());
				ps.setString(2, dto.getOrderUserId());
				ps.setString(3, dto.getOrderUserName());
				ps.setString(4, dto.getOrderProImg());
				ps.setString(5, dto.getOrderProName());
				ps.setInt(6, dto.getOrderProPrice());
				ps.setInt(7, dto.getOrderProAccount());
				ps.setInt(8, dto.getOrderTracking());
			}
		}); 
		
		String proSalseUpdate = "UPDATE product SET PROSALES=PROSALES+"+dto.getOrderProAccount()+" WHERE proName='" + dto.getOrderProName()+"'";

		template.update(proSalseUpdate);
	}
	
	// 리뷰 등록 시 출력버튼 변경 
	public void reviewChk(Double proReviewOrderNum, String proReviewProName) {
		String sql = "UPDATE buyOrder SET orderReviewContent=1 WHERE orderProNumber="+proReviewOrderNum+" AND orderProName='"+proReviewProName+"'";
		
		template.update(sql);
	}

	public void reviewDel(Double proReviewOrderNum, String proReviewProName) {
		String sql = "UPDATE buyOrder SET orderReviewContent=0 WHERE orderProNumber="+proReviewOrderNum+" AND orderProName='"+proReviewProName+"'";
		
		template.update(sql);
	}

}
