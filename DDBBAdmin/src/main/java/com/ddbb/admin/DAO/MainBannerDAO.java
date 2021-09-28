package com.ddbb.admin.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.MainBannerDTO;

@Repository
public class MainBannerDAO {
	
	private JdbcTemplate template;
	
	public MainBannerDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	//슬라이드 배너 전체 출력
	public ArrayList<MainBannerDTO> allList() {
		String sql = "SELECT * FROM mainbanner order by mainBannerSort";

		ArrayList<MainBannerDTO> list = null;

		try {
			list = (ArrayList<MainBannerDTO>)template.query(sql, new BeanPropertyRowMapper<MainBannerDTO>(MainBannerDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 슬라이드 배너 갯수 출력
	public int bannerCount() {
		String sql = "SELECT COUNT(*) FROM mainbanner ";
		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	   // 슬라이드 배너 추가
	   public void bannerAdd(final MainBannerDTO dto) {
	      String sql = "INSERT INTO mainbanner VALUES (mainbanner_seq.nextval,?,?,?,?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getMainBannerTitle());
				ps.setString(2, dto.getMainBannerImg());
				ps.setString(3, dto.getMainBannerLink());
				ps.setInt(4, dto.getMainBannerSort());
			}
		}); 
				
	}
	
	   //슬라이드 배너 상세 페이지 출력
	   public MainBannerDTO detailList(String mainBannerNum) {
	      String sql = "SELECT * FROM mainbanner WHERE mainBannerNum = '" + mainBannerNum + "'";
		MainBannerDTO dto = null;

		dto = template.queryForObject(sql, new BeanPropertyRowMapper<MainBannerDTO>(MainBannerDTO.class));
		return dto;
	}

	   //슬라이드 배너 수정
	   public void bannerModify(final MainBannerDTO dto) {
	      String sql = "update mainbanner set mainbannertitle=?, mainbannerimg=?, mainbannerlink=?, mainbannersort=? WHERE mainbannernum="+dto.getMainBannerNum();
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getMainBannerTitle());
				ps.setString(2, dto.getMainBannerImg());
				ps.setString(3, dto.getMainBannerLink());
				ps.setInt(4, dto.getMainBannerSort());
			}
		}); 
				
	}
	   //슬라이드 배너 삭제
	   public void bannerDelete(String bannerDelete) {
	      String sql = "DELETE FROM mainbanner WHERE mainBannerNum='" + bannerDelete + "'";
		template.update(sql);
	}
	
}
