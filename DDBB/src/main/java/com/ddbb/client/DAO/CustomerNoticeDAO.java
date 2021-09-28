package com.ddbb.client.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CustomerNoticeDTO;

@Repository
public class CustomerNoticeDAO {
	private JdbcTemplate template;

	public CustomerNoticeDAO(JdbcTemplate template) {
		this.template = template;
	}

	//공지사항 리스트 출력
	public ArrayList<CustomerNoticeDTO> customerNoticeAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customernotice " + 
								 searchSQL + 
//								 " order by cusnoticenum desc"+
				"            ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum+ "order by cusnoticenum desc";

		ArrayList<CustomerNoticeDTO> list = null;

		try {
			list = (ArrayList<CustomerNoticeDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerNoticeDTO>(CustomerNoticeDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 공지사항 갯수 출력
	public int noticeCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM customernotice " + searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 공지사항 상세 리스트 출력
	public CustomerNoticeDTO customerNoticeDetailList(String cusNoticeNum) {
		String sql = "SELECT * FROM customernotice WHERE cusnoticenum = '" + cusNoticeNum + "'";

		CustomerNoticeDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerNoticeDTO>(CustomerNoticeDTO.class));
		return dto;
	}
	
	//공지사항 검색
	public ArrayList<CustomerNoticeDTO> noticeSearch(String noticeSearch, String noticeOption) {
		String sql = null;
		if (noticeOption.equals("1")) {
			sql = "select * from customernotice where cusnoticetitle like '%" + noticeSearch + "%' order by cusnoticenum desc";
		} else if (noticeOption.equals("2")) {
			sql = "select * from customernotice where cusnoticecontent like '%" + noticeSearch + "%' order by cusnoticenum desc";
		} else{
			sql = "select * from customernotice where (cusnoticetitle like '%" + noticeSearch
					+ "%' or cusnoticecontent like '%" + noticeSearch + "%' order by cusnoticenum desc";
		}
		ArrayList<CustomerNoticeDTO> list = null;
		try {
			list = (ArrayList<CustomerNoticeDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerNoticeDTO>(CustomerNoticeDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	// 공지사항 메인 출력
	public ArrayList<CustomerNoticeDTO> customerNoticeMainList() {
		String sql = "SELECT *  FROM customernotice order by cusnoticenum desc";

		ArrayList<CustomerNoticeDTO> list = null;

		try {
			list = (ArrayList<CustomerNoticeDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerNoticeDTO>(CustomerNoticeDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	
	}
	

}
