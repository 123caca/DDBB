package com.ddbb.admin.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.UserDTO;

@Repository
public class UserDAO {
	private JdbcTemplate template;

	public UserDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	// 유저 리스트 출력
	public ArrayList<UserDTO> userList(String sort, String search, int pagingstart, int pagingend) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"               SELECT * " + 
				"               FROM userInfo" +
								search + sort + 
				"            ) A " + 
				"        )" + 
				" WHERE NUM BETWEEN " + pagingstart + " AND " + pagingend;

		ArrayList<UserDTO> list = null;

		try {
			list = (ArrayList<UserDTO>) template.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 유저 리스트 총 갯수
	public int userListTotal(String searchsql) {
		String sql = "SELECT COUNT(*) FROM userInfo" + searchsql;

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 유저 상세 정보
	public UserDTO userDetailList(String userId) {
		String sql = "SELECT * FROM userInfo WHERE userId = '" + userId + "'";
		UserDTO dto = null;
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
