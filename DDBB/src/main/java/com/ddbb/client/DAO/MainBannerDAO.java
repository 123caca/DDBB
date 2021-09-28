package com.ddbb.client.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.MainBannerDTO;

@Repository
public class MainBannerDAO {
	
	private JdbcTemplate template;
	
	public MainBannerDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	//슬라이드 배너 메인 출력
	public ArrayList<MainBannerDTO> mainBannerMainList(){
		
		String sql = "SELECT * FROM mainbanner ORDER BY mainbannersort";

		ArrayList<MainBannerDTO> list = null;

		try {
			list = (ArrayList<MainBannerDTO>)template.query(sql, new BeanPropertyRowMapper<MainBannerDTO>(MainBannerDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}

