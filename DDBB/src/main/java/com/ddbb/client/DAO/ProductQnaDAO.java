package com.ddbb.client.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CustomerQuestionDTO;
import com.ddbb.client.DTO.ProductDTO;
import com.ddbb.client.DTO.ProductQnaDTO;

@Repository
public class ProductQnaDAO {
	private JdbcTemplate template;
	
	public ProductQnaDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// 상품문의 전체 출력 및 검색
	public ArrayList<ProductQnaDTO> productQnaAllList(String listSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
					"    FROM (" + 
					"        SELECT ROWNUM NUM" + 
					"                , A.*" + 
					"            FROM (" + 
					"                SELECT * " +  
					"                FROM productQna " + 
									 listSQL +
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
	public int productCount(String listSQL) {
		String sql = "SELECT COUNT(*) FROM productQna " + listSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	

	
	// 상품문의 상세페이지 출력
	public ProductQnaDTO productQnaDetailList(String proQnaNum) {
		String sql = "SELECT * FROM productQna WHERE proQnaNum='"+proQnaNum+"'";
		ProductQnaDTO dto = null;

		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductQnaDTO>(ProductQnaDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	

	
	// 상품문의 추가 
	public void productQnaAdd(final ProductQnaDTO dto) {
		String sql = "INSERT INTO productQna "
				+ "VALUES(productQna_seq.nextval,"
				+ "?,?,?,?,"
				+ "?,TO_char(SYSDATE, 'yyyy-mm-dd'),NULL)";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getProQnaProName());
				ps.setString(2, dto.getProQnaTitle());
				ps.setString(3, dto.getProQnaContent());
				ps.setString(4, dto.getProQnaUserName());
				ps.setString(5, dto.getProQnaUserId());
			}
		}); 
	}
	

	
	// 상품문의 수정 페이지 ( 해당 게시글 정보 가져오기 )
	public ProductQnaDTO productQnaModify(String proQnaNum) {
		String sql = "SELECT * FROM productQna WHERE proQnaNum='" + proQnaNum + "'";
		
		ProductQnaDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductQnaDTO>(ProductQnaDTO.class));
		return dto;
	}
	
	// 상품 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
	public void productQnaModifyFn(final ProductQnaDTO dto) {
		String sql = "UPDATE productQna "
				+ "SET proQnaUserName=?, "
				+ "proQnaTitle=?, proQnaContent=? "
				+ "WHERE proQnaNum=?";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getProQnaUserName());
				ps.setString(2, dto.getProQnaTitle());
				ps.setString(3, dto.getProQnaContent());
				ps.setInt(4, dto.getProQnaNum());
			}
		}); 
	}
	

	
	// 상품문의 삭제
	public void productQnaDelete(String proQnaNum) {
		String sql = "DELETE FROM productQna WHERE proQnaNum='" + proQnaNum + "'";
		
		template.update(sql);
	}
	

	
	// 나의 Q&A 내역
	public ArrayList<ProductQnaDTO> productQnaMyQna(String userId) {
		String sql = "SELECT * FROM productQna WHERE proQnaUserId='"+userId+"' ORDER BY proQnaNum DESC";
		ArrayList<ProductQnaDTO> list = null;

		try {
			list = (ArrayList<ProductQnaDTO>)template.query(sql, new BeanPropertyRowMapper<ProductQnaDTO>(ProductQnaDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 나의 상품 Qna 전체 출력
	public ArrayList<ProductQnaDTO> UserQuestionProductQnaList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM productQna " + 
								 searchSQL + 
				"            ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum +"order by proQnaNum desc";

		ArrayList<ProductQnaDTO> list = null;

		try {
			list = (ArrayList<ProductQnaDTO>) template.query(sql,
					new BeanPropertyRowMapper<ProductQnaDTO>(ProductQnaDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
		}

	public int UserQuestionProductQnaCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM productQna " + searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;	}

}
