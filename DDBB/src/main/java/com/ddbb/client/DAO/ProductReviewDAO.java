package com.ddbb.client.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.ProductReviewDTO;

@Repository
public class ProductReviewDAO {
	private JdbcTemplate template;
	
	public ProductReviewDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// 상품리뷰 전체 출력 및 검색
	public ArrayList<ProductReviewDTO> productReviewAllList(String listSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM productReview " + 
								 listSQL +
				"            ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum;
	
		ArrayList<ProductReviewDTO> list = null;
	
		try {
			list = (ArrayList<ProductReviewDTO>)template.query(sql, new BeanPropertyRowMapper<ProductReviewDTO>(ProductReviewDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 총 게시글 갯수 출력
	public int productCount(String listSQL) {
		String sql = "SELECT COUNT(*) FROM productReview " + listSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	
	// 상품리뷰 추가 
	public void productReviewAdd(final ProductReviewDTO dto) {
		String sql = "INSERT INTO productReview "
				+ "VALUES(productReview_seq.nextval,"
				+ "?,?,?,?,?,?,?,"
				+ "TO_char(SYSDATE, 'yyyy-mm-dd'))";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setDouble(1, dto.getProReviewOrderNum());
				ps.setString(2, dto.getProReviewProName());
				ps.setString(3, dto.getProReviewUserId());
				ps.setString(4, dto.getProReviewUserName());
				ps.setInt(5, dto.getProReviewScore());
				ps.setString(6, dto.getProReviewImg());
				ps.setString(7, dto.getProReviewContent());
			}
		}); 
	}
	

	
	// 상품리뷰 수정 페이지 ( 해당 게시글 정보 가져오기 )
	public ProductReviewDTO productReviewModify(Double proReviewOrderNum, String proReviewProName) {
		String sql = "SELECT * FROM productReview WHERE proReviewOrderNum='" + proReviewOrderNum + "' AND proReviewProName='" + proReviewProName + "'";
		
		ProductReviewDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductReviewDTO>(ProductReviewDTO.class));
		return dto;
	}
	
	// 상품 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
	public void productReviewModifyFn(final ProductReviewDTO dto) {
		String sql = "UPDATE productReview "
				+ "SET proReviewScore=?, proReviewImg=?, proReviewContent=? "
				+ "WHERE proReviewOrderNum=? AND proReviewProName=?";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, dto.getProReviewScore());
				ps.setString(2, dto.getProReviewImg());
				ps.setString(3, dto.getProReviewContent());
				ps.setDouble(4, dto.getProReviewOrderNum());
				ps.setString(5, dto.getProReviewProName());
			}
		}); 
	}
	
	
	// 상품리뷰 삭제
	public void productReviewDelete(Double proReviewOrderNum, String proReviewProName) {
		String sql = "DELETE FROM productReview WHERE proReviewOrderNum='" + proReviewOrderNum + "' AND proReviewProName='" + proReviewProName + "'";
		
		template.update(sql);
	}

}
