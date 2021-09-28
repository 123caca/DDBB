package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.CustomerQuestionDTO;

@Repository
public class CustomerQuestionDAO {

	private JdbcTemplate template;

	public CustomerQuestionDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 1:1 질문 전체 출력
	public ArrayList<CustomerQuestionDTO> customerQuestionAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customerquestion " + 
								 searchSQL + 
				"				 order by cusquestionnum desc" +
				"            ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum;

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

	// 1:1 질문 상세 리스트
	public CustomerQuestionDTO customerQuestionDetailList(String cusQuestionNum) {
		String sql = "SELECT * FROM customerquestion WHERE cusquestionnum = '" + cusQuestionNum + "'";
		CustomerQuestionDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerQuestionDTO>(CustomerQuestionDTO.class));
		return dto;
	}

	// 1:1 질문 답변 추가
	
	public void customerQuestionAnswer(final CustomerQuestionDTO dto) {
		String sql = "UPDATE customerquestion set cusquestionanswer=? where cusquestionnum = ? ";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusQuestionAnswer());
				ps.setInt(2, dto.getCusQuestionNum());
			}
		}); 
	}

	// 1:1 질문 삭제
	public void customerQuestionDelete(String questionDel) {
		String sql = "DELETE FROM customerquestion WHERE cusquestionnum='" + questionDel + "'";
		template.update(sql);
	}
	
	// 1:1 질문 전체 출력
	public ArrayList<CustomerQuestionDTO> customerQuestionNoAnswerList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customerquestion " + 
								 searchSQL + 
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
	
	// 1:1 질문 미답변 갯수 출력
	public int questionNoAnswerCount() {
		String sql = "SELECT COUNT(*) FROM customerquestion WHERE cusQuestionAnswer IS NULL";
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	
}
