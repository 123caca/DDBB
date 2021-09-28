package com.ddbb.admin.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.ProductDTO;

@Repository
public class PagingDAO {
	private JdbcTemplate template;
	
	public PagingDAO(JdbcTemplate template) {
		this.template = template;
	}
	

	// 페이징 처리 후 게시글 조회
	public ArrayList<ProductDTO> productAllList(String proSort, int startNum, int endNum) {

		String msg = "";
		if (proSort.equals("1"))
			msg = "ORDER BY proSales DESC";
		else if (proSort.equals("2"))
			msg = "ORDER BY proName";
		else if (proSort.equals("3"))
			msg = "ORDER BY proPrice ASC";
		else if (proSort.equals("4"))
			msg = "ORDER BY proPrice DESC";
		else {
			msg = "";
		}
		
		String sql = "SELECT * " + 
					"    FROM (" + 
					"        SELECT ROWNUM NUM" + 
					"                , A.*" + 
					"            FROM (" + 
					"                SELECT * " +  
					"                FROM product " + 
									msg + 
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
	public int countList() {
		String sql = "SELECT COUNT(*) FROM product";
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

}
