package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.CustomerEventDTO;

@Repository
public class CustomerEventDAO {
	
	private JdbcTemplate template;
	
	public CustomerEventDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// 이벤트 전체 리스트 출력
	public ArrayList<CustomerEventDTO> customerEventAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customerevent " + 
								 searchSQL +
				"				 ORDER BY cusEventNum DESC" +
				"            ) A" + 
				"        )" + 
				"WHERE NUM BETWEEN "+startNum+" AND "+endNum;

		ArrayList<CustomerEventDTO> list = null;

		try {
			list = (ArrayList<CustomerEventDTO>) template.query(sql,
					new BeanPropertyRowMapper<CustomerEventDTO>(CustomerEventDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 이벤트 갯수 출력
	public int eventCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM customerevent "+searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}

	//이벤트 추가
	public void customerEventAdd(final CustomerEventDTO dto) {
		String sql = "INSERT INTO customerevent "
				+ "VALUES (cuseventnum_seq.nextval,?,?,?,to_char(?,'yyyy.mm.dd'),to_char(?,'yyyy.mm.dd'),TO_char(SYSDATE, 'yyyy-mm-dd'))";

		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusEventTitle());
				ps.setString(2, dto.getCusEventContentsImg());
				ps.setString(3, dto.getCusEventThumbnailImg());
				ps.setString(4, dto.getCusEventStartDate());
				ps.setString(5, dto.getCusEventEndDate());
			}
		}); 
				
	}
	
	//이벤트 상세 리스트 
	public CustomerEventDTO customerEventDetailList(int cuseventnum) {
		String sql = "SELECT * FROM customerevent WHERE cuseventnum = " + cuseventnum;

		CustomerEventDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerEventDTO>(CustomerEventDTO.class));
		return dto;
	}
	
	//이벤트 수정
	public void customerEventModify(final CustomerEventDTO dto) {
		String sql = "UPDATE customerevent  "
				+ "SET cuseventtitle =?, cuseventcontentsimg =?, cuseventthumbnailimg =?, cuseventstartdate =to_date(?,'yyyy.mm.dd'), cuseventenddate =to_date(?,'yyyy.mm.dd')"
				+ "WHERE cuseventnum ="+dto.getCuseventnum();

		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getCusEventTitle());
				ps.setString(2, dto.getCusEventContentsImg());
				ps.setString(3, dto.getCusEventThumbnailImg());
				ps.setString(4, dto.getCusEventStartDate());
				ps.setString(5, dto.getCusEventEndDate());
				
			}
		}); 
	}
		
	
	//이벤트 삭제
	public void customerEventDelete(String eventDel) {
		String sql = "DELETE FROM customerevent WHERE cuseventnum =" + eventDel;
		template.update(sql);
	}
}	
