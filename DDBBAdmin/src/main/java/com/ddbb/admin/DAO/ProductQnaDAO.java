package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.ProductDTO;
import com.ddbb.admin.DTO.ProductQnaDTO;

@Repository
public class ProductQnaDAO {
	private JdbcTemplate template;
	
	public ProductQnaDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// 상품 Q&A 전체 리스트 출력
	public ArrayList<ProductQnaDTO> productAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
					"    FROM (" + 
					"        SELECT ROWNUM NUM" + 
					"                , A.*" + 
					"            FROM (" + 
					"                SELECT * " +  
					"                FROM productQna " + 
									 searchSQL + 
					"				 ORDER BY proQnaNum DESC" +
					"            ) A" + 
					"        )" + 
					"WHERE NUM BETWEEN "+startNum+" AND "+endNum;
		
		ArrayList<ProductQnaDTO> list = null;

		try {
			list = (ArrayList<ProductQnaDTO>)template.query(sql, new BeanPropertyRowMapper<ProductQnaDTO>(ProductQnaDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 총 게시글 갯수 출력
	public int productCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM productQna " + searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	// 상품 Q&A 상세 페이지 출력
	public ProductQnaDTO productQnaAnswer(String proQnaNum) {
		String sql = "SELECT * FROM productQna WHERE proQnaNum='"+proQnaNum+"'";
		ProductQnaDTO dto = null;

		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductQnaDTO>(ProductQnaDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 상품 Q&A 답글
	public void productQnaAnswerFn(String proQnaAnswer, String proQnaNum) {
		String sql = "UPDATE productQna "
				+ "SET proQnaAnswer='" + proQnaAnswer + "' "
				+ "WHERE proQnaNum=" + proQnaNum;

		template.update(sql);
	}

	// 상품 Q&A 삭제
	public void productQnaDelete(String proDelete) {
		String sql = "DELETE FROM productQna WHERE proQnaNum='" + proDelete + "'";
		
		template.update(sql);
	}
	
	// 상품 Q&A 질문 미답변 갯수 출력
	public int productNoAnswerCount() {
		String sql = "SELECT COUNT(*) FROM productQna WHERE proQnaAnswer IS NULL";
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

}
