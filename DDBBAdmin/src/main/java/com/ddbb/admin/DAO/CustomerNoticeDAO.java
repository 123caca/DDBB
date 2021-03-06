package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.CustomerNoticeDTO;

@Repository
public class CustomerNoticeDAO {

	private JdbcTemplate template;

	public CustomerNoticeDAO(JdbcTemplate template) {
		this.template = template;
	}

	public ArrayList<CustomerNoticeDTO> customerNoticeAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customernotice " + 
								 searchSQL + 
				"				 ORDER BY cusNoticeNum DESC" +
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
	
	// 공지사항 추가
	public void customerNoticeAdd(final CustomerNoticeDTO dto) {
		String sql = "insert into customernotice values (customernotice_seq.nextval,?,?,TO_char(SYSDATE, 'yyyy-mm-dd'))";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusNoticeTitle());
				ps.setString(2, dto.getCusNoticeContent());
				}
			});
		}

	// 공지사항 세부 내역
	public CustomerNoticeDTO customerNoticeDetailList(String cusNoticeNum) {
		String sql = "SELECT * FROM customernotice WHERE cusNoticeNum = '" + cusNoticeNum + "'";

		CustomerNoticeDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerNoticeDTO>(CustomerNoticeDTO.class));
		return dto;
	}

	// 공지사항 수정
	public void customerNoticeModify(final CustomerNoticeDTO dto) {
		String sql = "UPDATE customernotice "
				+ "SET cusnoticetitle =?, cusnoticecontent=?"
				+ "WHERE cusnoticenum=?";
		template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusNoticeTitle());
				ps.setString(2, dto.getCusNoticeContent());
				ps.setInt(3, dto.getCusNoticeNum());
			}
		});
	}
	
	// 공지사항 삭제
	public void customerNoticeDelete(String questionDel) {
		String sql = "DELETE FROM customernotice WHERE cusnoticenum='" + questionDel + "'";
		
		template.update(sql);
	}
	
	// 공지사항 검색
	public ArrayList<CustomerNoticeDTO> noticeSearch(String noticeSearch, String noticeOption) {
		String sql = null;
		if (noticeOption.equals("1")) {
			sql = "select * from customernotice where cusnoticetitle like '%" + noticeSearch + "%'";
		} else if (noticeOption.equals("2")) {
			sql = "select * from customernotice where cusnoticecontent like '%" + noticeSearch + "%'";
		} else {
			sql = "select * from customernotice where (cusnoticetitle like '%" + noticeSearch
					+ "%' or cusnoticeontent like '%" + noticeSearch + "%'";
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

}
