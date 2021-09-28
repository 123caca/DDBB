package com.ddbb.client.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CustomerEventDTO;
import com.ddbb.client.DTO.CustomerFaqDTO;
import com.ddbb.client.DTO.CustomerNoticeDTO;
import com.ddbb.client.DTO.CustomerQuestionDTO;
import com.ddbb.client.DTO.ProductDTO;
import com.ddbb.client.DTO.ProductQnaDTO;

@Repository
public class MainDAO {
	private JdbcTemplate template;

	public MainDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 전체 검색 상품 리스트
	public ArrayList<ProductDTO> productSearch(String search) {
		String sql = "SELECT * " + "    FROM (" + "        SELECT ROWNUM NUM" + "                , A.*"
				+ "            FROM (" + "               SELECT * " + "               FROM product WHERE "
				+ "proName  LIKE '%" + search + "%'           ) A" + "        )" + "WHERE NUM BETWEEN 1 AND 5";
		ArrayList<ProductDTO> list = null;

		try {
			list = (ArrayList<ProductDTO>) template.query(sql, new BeanPropertyRowMapper<ProductDTO>(ProductDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 전체 검색 상품 리스트 총 갯수
	public int productSearchTotal(String search) {
		String sql = "SELECT COUNT(*) FROM product WHERE proName  LIKE '%" + search + "%'";

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	// 전체 검색 자주하는 질문 리스트
	public ArrayList<CustomerFaqDTO> customerFaqSearch(String search) {
		String sql = "SELECT * " + "    FROM (" + "        SELECT ROWNUM NUM" + "                , A.*"
				+ "            FROM (" + "               SELECT * " + "               FROM customerfaq WHERE "
				+ "cusfaqtitle  LIKE '%" + search + "%' or cusfaqcontent  LIKE '%" + search + "%'     ) A" + "        )"
				+ "WHERE NUM BETWEEN 1 AND 5";
		ArrayList<CustomerFaqDTO> list = null;

		try {
			list = (ArrayList<CustomerFaqDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerFaqDTO>(CustomerFaqDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 전체 검색 자주하는 질문 리스트 총 갯수
	public int customerFaqSearchTotal(String search) {
		String sql = "SELECT COUNT(*) FROM customerfaq WHERE cusfaqtitle  LIKE '%" + search
				+ "%' or cusfaqcontent  LIKE '%" + search + "%'";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	// 전체 검색 1:1 문의 리스트
	public ArrayList<CustomerQuestionDTO> customerQuestionSearch(String search) {
		String sql = "SELECT * " + "    FROM (" + "        SELECT ROWNUM NUM" + "                , A.*"
				+ "            FROM (" + "               SELECT * " + "               FROM customerquestion WHERE "
				+ "cusquestiontitle  LIKE '%" + search + "%' or cusquestioncontent  LIKE '%" + search + "%'     ) A"
				+ "        )" + "WHERE NUM BETWEEN 1 AND 5";
		ArrayList<CustomerQuestionDTO> list = null;

		try {
			list = (ArrayList<CustomerQuestionDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerQuestionDTO>(CustomerQuestionDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 전체 검색 1:1 문의 리스트 총 갯수
	public int customerQuestionSearchTotal(String search) {
		String sql = "SELECT COUNT(*) FROM customerquestion WHERE cusquestiontitle  LIKE '%" + search
				+ "%' or cusquestioncontent  LIKE '%" + search + "%'";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	// 전체 검색 공지사항 리스트 
	public ArrayList<CustomerNoticeDTO> customerNoticeSearch(String search) {
		String sql = "SELECT * " + "    FROM (" + "        SELECT ROWNUM NUM" + "                , A.*"
				+ "            FROM (" + "               SELECT * " + "               FROM customernotice WHERE "
				+ "cusnoticetitle  LIKE '%" + search + "%' or cusnoticecontent  LIKE '%" + search + "%'     ) A"
				+ "        )" + "WHERE NUM BETWEEN 1 AND 5";
		ArrayList<CustomerNoticeDTO> list = null;

		try {
			list = (ArrayList<CustomerNoticeDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerNoticeDTO>(CustomerNoticeDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// 전체 검색 공지하상 리스트 총 갯수
	public int customerNoticeSearchTotal(String search) {
		String sql = "SELECT COUNT(*) FROM customernotice WHERE cusnoticetitle  LIKE '%" + search
				+ "%' or cusnoticecontent  LIKE '%" + search + "%'";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	// 전체 검색 이벤트 리스트 
	public ArrayList<CustomerEventDTO> customerEventSearch(String search) {
		String sql = "SELECT * " + "    FROM (" + "        SELECT ROWNUM NUM" + "                , A.*"
				+ "            FROM (" + "               SELECT * " + "               FROM customerevent WHERE "
				+ "cuseventtitle  LIKE '%" + search + "%'     ) A"
				+ "        )" + "WHERE NUM BETWEEN 1 AND 5";
		ArrayList<CustomerEventDTO> list = null;

		try {
			list = (ArrayList<CustomerEventDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerEventDTO>(CustomerEventDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// 전체 검색 이벤트 리스트 총 갯수
	public int customerEventSearchTotal(String search) {
		String sql = "SELECT COUNT(*) FROM customerevent WHERE cuseventtitle  LIKE '%" + search
				+ "%'";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

}
