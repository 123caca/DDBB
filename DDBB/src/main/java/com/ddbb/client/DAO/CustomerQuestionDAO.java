package com.ddbb.client.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CustomerQuestionDTO;

@Repository
public class CustomerQuestionDAO {

	private JdbcTemplate template;

	public CustomerQuestionDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 1:1문의 전체 리스트 출력
	public ArrayList<CustomerQuestionDTO> customerQuestionAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customerquestion " + 
								 searchSQL +
//				"				 order by cusquestionnum desc"+ 
				"            ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum +"order by cusquestionnum desc";

		ArrayList<CustomerQuestionDTO> list = null;

		try {
			list = (ArrayList<CustomerQuestionDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerQuestionDTO>(CustomerQuestionDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 1:1 질문 갯수 출력
		public int questionCount(String searchSQL) {
			String sql = "SELECT COUNT(*) FROM customerquestion " + searchSQL;
			
			int count = template.queryForObject(sql, Integer.class);
			return count;
		}

	// 1:1문의 상세 페이지 출력
	public CustomerQuestionDTO customerQuestionDetailList(String cusQuestionNum) {
		String sql = "SELECT * FROM customerquestion WHERE cusquestionnum = '" + cusQuestionNum + "'";

		CustomerQuestionDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerQuestionDTO>(CustomerQuestionDTO.class));
		return dto;
	}

	// 1:1문의 등록
	public void customerQuestionAdd(final CustomerQuestionDTO dto) {
//		String sql = "insert into customerquestion values(customerquestion_seq.nextval,?,?,?,?,sysdate,null,1)";
		String sql = "insert into customerquestion values(customerquestion_seq.nextval,?,?,?,?,TO_char(SYSDATE, 'yyyy-mm-dd'),null,1)";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusQuestionTitle());
				ps.setString(2, dto.getCusQuestionContent());
				ps.setString(3, dto.getCusQuestionUserId());
				ps.setString(4, dto.getCusQuestionUserName());

			}
		});
	}

	// 1:1 문의 수정 페이지 출력
	public CustomerQuestionDTO customerQuestionModify(String cusQuestionNum) {
		String sql = "select * FROM customerquestion WHERE cusQuestionNum = '" + cusQuestionNum + "'";

		CustomerQuestionDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerQuestionDTO>(CustomerQuestionDTO.class));
		return dto;
	}
	

	// 1:1 문의 수정
	public void customerQuestionModifyFin(final CustomerQuestionDTO dto) {
		String sql = "update customerquestion set cusquestiontitle=?, cusquestioncontent=? where cusquestionnum=?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusQuestionTitle());
				ps.setString(2, dto.getCusQuestionContent());
				ps.setInt(3, dto.getCusQuestionNum());

			}
		});
	}
	// 1:1 문의 삭제
	public void customerQuestionDelete(int cusQuestionNum) {
		String sql = "delete FROM customerquestion WHERE cusquestionnum = " + cusQuestionNum ;
		template.update(sql);
	}

	// 1:1 문의 검색
	public ArrayList<CustomerQuestionDTO> questionSearch(String questionSearch, String questionOption) {
		String sql = null;
		if (questionOption.equals("1")) {
			sql = "select * from customerquestion where cusquestiontitle like '%" + questionSearch + "%' order by cusquestionnum desc";
		} else if (questionOption.equals("2")) {
			sql = "select * from customerquestion where cusquestioncontent like '%" + questionSearch + "%' order by cusquestionnum desc";
		} else {
			sql = "select * from customerquestion where (cusquestiontitle like '%" + questionSearch
					+ "%' or cusquestioncontent like '%" + questionSearch + "%' order by cusquestionnum desc";
		}
		ArrayList<CustomerQuestionDTO> list = null;
		System.out.println(sql);
		try {
			list = (ArrayList<CustomerQuestionDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerQuestionDTO>(CustomerQuestionDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
