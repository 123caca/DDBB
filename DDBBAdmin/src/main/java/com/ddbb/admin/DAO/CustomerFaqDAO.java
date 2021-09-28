package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.CustomerFaqDTO;
import com.ddbb.admin.DTO.CustomerNoticeDTO;

@Repository
public class CustomerFaqDAO {
	
	private JdbcTemplate template;
	
	public CustomerFaqDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	//자주 묻는 질문 전체 출력
	public ArrayList<CustomerFaqDTO> customerFaqAllList(String searchSQL) {
		String sql = "SELECT * FROM customerfaq" + searchSQL;

		ArrayList<CustomerFaqDTO> list = null;

		try {
			list = (ArrayList<CustomerFaqDTO>)template.query(sql, new BeanPropertyRowMapper<CustomerFaqDTO>(CustomerFaqDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 자주 하는 질문 갯수 출력
	public int faqCount() {
		String sql = "SELECT COUNT(*) FROM customerfaq ";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 자주 하는 질문 추가	
	public void customerFaqAdd(final CustomerFaqDTO dto) {
		String sql = "insert into customerfaq values(cusfaqnum_seq.nextval,?,?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusFaqTitle());
				ps.setString(2, dto.getCusFaqContent());
				}
			});
		}
	
	// 자주하는 질문 수정
	public void customerFaqModify(final CustomerFaqDTO dto) {
		String sql = "update customerfaq set cusfaqtitle=?, cusfaqcontent=? where cusfaqnum="+dto.getCusFaqNum();
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusFaqTitle());
				ps.setString(2, dto.getCusFaqContent());
			}
		});
	}
	
	//자주 하는 질문 상세 페이지
	public CustomerFaqDTO customerFaqDetailList(String cusfaqnum) {
		String sql = "SELECT * FROM customerfaq WHERE cusfaqnum = " + cusfaqnum ;

		CustomerFaqDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerFaqDTO>(CustomerFaqDTO.class));
		return dto;
	}
		
	// 자주하는 질문 삭제
	public void customerFaqDelete(String cusfaqnum) {
		String sql = "DELETE FROM customerfaq WHERE cusfaqnum=" + cusfaqnum;
		template.update(sql);
		}
	
	// 자주 하는 질문 검색
	public ArrayList<CustomerFaqDTO> faqSearch(String faqSearch, String faqOption) {
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
		try {
			list = (ArrayList<CustomerFaqDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerFaqDTO>(CustomerFaqDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
