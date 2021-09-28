package com.ddbb.client.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CustomerFaqDTO;

@Repository
public class CustomerFaqDAO {
	private JdbcTemplate template;
	
	public CustomerFaqDAO(JdbcTemplate template) {
		this.template = template;
	}

	//자주 묻는 질문 전체 출력
	public ArrayList<CustomerFaqDTO> customerFaqAllList(String searchSQL) {
		String sql = "select * from customerfaq" + searchSQL;

		ArrayList<CustomerFaqDTO> list = null;

		try {
			list = (ArrayList<CustomerFaqDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerFaqDTO>(CustomerFaqDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 자주 묻는 질문 검색
	public ArrayList<CustomerFaqDTO> customerFaqSearch(String faqSearch, String faqOption) {
		String sql = null;
		if (faqOption.equals("1")) {
			sql = "select * from customerfaq where cusfaqtitle like '%" + faqSearch + "%'";
		} else if (faqOption.equals("2")) {
			sql = "select * from customerfaq where cusfaqcontent like '%" + faqSearch + "%'";
		} else {
			sql = "select * from customerfaq where (cusfaqtitle like '%" + faqSearch
					+ "%' or cusquestioncontent like '%" + faqSearch + "%'";
		}
		ArrayList<CustomerFaqDTO> list = null;
		System.out.println(sql);
		try {
			list = (ArrayList<CustomerFaqDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerFaqDTO>(CustomerFaqDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
