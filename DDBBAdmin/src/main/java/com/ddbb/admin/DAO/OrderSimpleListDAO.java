package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.OrderSimpleListDTO;

@Repository
public class OrderSimpleListDAO {
	private JdbcTemplate template;
	
	public OrderSimpleListDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 주문조회 페이지 출력
	public ArrayList<OrderSimpleListDTO> orderSimpleList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"           FROM (" + 
				"               SELECT * " +  
				"               FROM buyOrderSimple " + 
								searchSQL +
				"				ORDER BY orderProNumber DESC" +
				"           ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum;
		
		ArrayList<OrderSimpleListDTO> list = null;
	
		try {
			list = (ArrayList<OrderSimpleListDTO>)template.query(sql, new BeanPropertyRowMapper<OrderSimpleListDTO>(OrderSimpleListDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 총 게시글 갯수 출력
	public int orderSimpleCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM buyOrderSimple " + searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	
	// 주문조회 데이터 추가
	public void orderSimpleAdd(final OrderSimpleListDTO dto) {
		String sql = "INSERT INTO buyOrderSimple "
				+ "VALUES(?,?,?,TO_CHAR(SYSDATE, 'yyyy-mm-dd'),"
				+ "?,?,?,?)";
		
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getOrderProNumber());
				ps.setString(2, dto.getOrderUserId());
				ps.setString(3, dto.getOrderUserName());
				ps.setString(4, dto.getOrderProImg());
				ps.setString(5, dto.getOrderProName());
				ps.setInt(6, dto.getOrderTracking());
				ps.setInt(7, dto.getOrderSimTotalCost());
			}
		}); 
	}
	
	// 주문조회 수정
	public void orderModify(String orderProNumber) {
		String sql = "UPDATE buyOrderSimple SET orderTracking=2 WHERE orderProNumber='" + orderProNumber + "'";
		
		template.update(sql);
	}
	
	// 주문조회 배송 대기중인 상품 갯수 출력
	public int orderWaitCount() {
		String sql = "SELECT COUNT(*) FROM buyOrderSimple WHERE orderTracking=1";
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
}
