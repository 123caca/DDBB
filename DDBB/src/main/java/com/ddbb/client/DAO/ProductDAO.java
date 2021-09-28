package com.ddbb.client.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.ProductDTO;

@Repository
public class ProductDAO {
	private JdbcTemplate template;

	public ProductDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 상품 전체 리스트 출력
	public ArrayList<ProductDTO> productCategoryList(String sortSQL, String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + "    FROM (" + "        SELECT ROWNUM NUM" + "                , A.*"
				+ "           FROM (" + "               SELECT * " + "               FROM product " + searchSQL
				+ sortSQL + "           ) A" + "        )" + "WHERE NUM BETWEEN " + startNum + " AND " + endNum;
		ArrayList<ProductDTO> list = null;

		try {
			list = (ArrayList<ProductDTO>) template.query(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				String reviewSQL = " WHERE PROREVIEWPRONAME= '" + list.get(i).getProName() + "'";
				list.get(i).setProReviewTotal(productReviewCount(reviewSQL));
			}
		}
		return list;
	}

	// 총 리뷰 게시글 갯수 출력
	public int productReviewCount(String listSQL) {
		String sql = "SELECT COUNT(*) FROM productReview " + listSQL;

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	// 총 게시글 갯수 출력
	public int productCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM product " + searchSQL;

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	// 상품 상세 페이지 출력
	public ProductDTO productDetailList(String proName) {
		String sql = "SELECT * FROM product WHERE proName='" + proName + "' ORDER BY proName";
		ProductDTO dto = null;

		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 인덱스 페이지 베스트 상품 출력
	public ArrayList<ProductDTO> productMainList() {
		String sql = "SELECT * FROM product ORDER BY proSales";
		ArrayList<ProductDTO> list = null;

		try {
			list = (ArrayList<ProductDTO>) template.query(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 상품 검색
	public ArrayList<ProductDTO> productSearch(String proCategory, String proSearch) {
		String sql = "SELECT * FROM product WHERE proCategory='" + proCategory + "' LIKE '%" + proSearch + "%'";
		ArrayList<ProductDTO> list = null;

		try {
			list = (ArrayList<ProductDTO>) template.query(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 상품페이지에서 결제 할 때 데이터 가져오기
	public ProductDTO productSearch(String proName) {
		String sql = "SELECT * FROM product WHERE proName='" + proName + "'";
		ProductDTO dto = null;

		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
