package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.ProductDTO;

@Repository
public class ProductDAO {
	private JdbcTemplate template;
	
	public ProductDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// 상품 전체 리스트 출력
	public ArrayList<ProductDTO> productAllList(String sortSQL, String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
					"    FROM (" + 
					"        SELECT ROWNUM NUM" + 
					"                , A.*" + 
					"            FROM (" + 
					"                SELECT * " +  
					"                FROM product " + 
									 searchSQL + sortSQL + 
					"            ) A" + 
					"        )" + 
					"WHERE NUM BETWEEN "+startNum+" AND "+endNum;
		
		ArrayList<ProductDTO> list = null;

		try {
			list = (ArrayList<ProductDTO>)template.query(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 총 게시글 갯수 출력
	public int productCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM product " + searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	
	// 상품 추가 페이지
	public void productAdd(final ProductDTO dto) {
		String sql = "INSERT INTO product(proCategory, proName, proPrice, proImg, proContentImg, proSales) "
				+ "VALUES(?,?,?,?,?,0)";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getProCategory());
				ps.setString(2, dto.getProName());
				ps.setInt(3, dto.getProPrice());
				ps.setString(4, dto.getProImg());
				ps.setString(5, dto.getProContentImg());
			}
		}); 
	}
	
	
	// 상품 수정 페이지 ( 해당 게시글 정보 가져오기 )
	public ProductDTO productModify(String proName) {
		String sql = "SELECT * FROM product WHERE proName='" + proName + "'";
		
		ProductDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		return dto;
	}
	
	// 상품 수정 페이지 ( 새로 입력한 값으로 데이터 수정 )
	public void productModifyFn(final ProductDTO dto) {
		String sql = "UPDATE product "
				+ "SET proCategory=?, proName=?, proPrice=?, proImg=?, proContentImg=?"
				+ "WHERE proName=?";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getProCategory());
				ps.setString(2, dto.getProName());
				ps.setInt(3, dto.getProPrice());
				ps.setString(4, dto.getProImg());
				ps.setString(5, dto.getProContentImg());
				ps.setString(6, dto.getProName());
			}
		}); 
	}

	// 상품 삭제
	public void productDelete(String proDelete) {
		String sql = "DELETE FROM product WHERE proName='" + proDelete + "'";
		
		template.update(sql);
	}
	
}
