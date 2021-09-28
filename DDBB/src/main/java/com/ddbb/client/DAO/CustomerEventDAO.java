package com.ddbb.client.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.CustomerEventDTO;

@Repository
public class CustomerEventDAO {
	
	private JdbcTemplate template;
	
	public CustomerEventDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 이벤트 전체 출력
	public ArrayList<CustomerEventDTO> customerEventAllList(String searchSQL, int startNum, int endNum) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"                SELECT * " +  
				"                FROM customerevent " + 
								 searchSQL + 
//								 " order by cuseventnum desc"+
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
		System.out.println(list);
		return list;
	}

	// 이벤트 갯수 출력
	public int eventCount(String searchSQL) {
		String sql = "SELECT COUNT(*) FROM customerevent" +searchSQL;
		
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	//이벤트 상세 페이지 출력
	public CustomerEventDTO customerEventDetailList(int cuseventnum) {
		String sql = "SELECT * FROM customerevent WHERE cuseventnum = " + cuseventnum;
		CustomerEventDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<CustomerEventDTO>(CustomerEventDTO.class));
		return dto;
	}

	//이벤트 메인 페이지 출력
	public ArrayList<CustomerEventDTO> customerEventMainList(){
		
		String sql = "SELECT * FROM customerevent WHERE cuseventstartdate<=sysdate and cuseventenddate>sysdate";

		ArrayList<CustomerEventDTO> list = null;

		try {
			list = (ArrayList<CustomerEventDTO>)template.query(sql, new BeanPropertyRowMapper<CustomerEventDTO>(CustomerEventDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
