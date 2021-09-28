package com.ddbb.admin.DAO;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.admin.DTO.AdminUserDTO;
@Repository
public class AdminUserDAO {
	private JdbcTemplate template;

	public AdminUserDAO(JdbcTemplate template) {
		this.template=template;
	}
	// 관리자 로그인 
	public AdminUserDTO adminUserLogin(String adminuserId, String adminuserPwd) {
		String sql="SELECT * FROM adminUser WHERE adminUserId = '"+adminuserId+"' and adminUserPwd='"+adminuserPwd+"'";
		AdminUserDTO dto=null;
		try {
			dto=template.queryForObject(sql, new BeanPropertyRowMapper<AdminUserDTO>(AdminUserDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	// 관리자 리스트 출력
	public ArrayList<AdminUserDTO> adminUserList(String sort, String search, int pagingstart, int pagingend) {
		String sql = "SELECT * " + 
				"    FROM (" + 
				"        SELECT ROWNUM NUM" + 
				"                , A.*" + 
				"            FROM (" + 
				"               SELECT * " + 
				"               FROM adminUser" + 
								search + sort + 
				"            ) A" + 
				"        )" + 
				" WHERE NUM BETWEEN " + pagingstart + " AND " + pagingend;

		ArrayList<AdminUserDTO> list = null;

		try {
			list = (ArrayList<AdminUserDTO>) template.query(sql, new BeanPropertyRowMapper<AdminUserDTO>(AdminUserDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// 관리자 리스트 총 갯수
	public int adminUserListTotal(String searchsql) {
		String sql = "SELECT COUNT(*) FROM adminUser" + searchsql;

		int count = template.queryForObject(sql, Integer.class);
		return count;
	}
	
	// 관리자 정보 상세 출력
	public AdminUserDTO adminUserDetailList(String adminuserId) {
		String sql = "SELECT * FROM adminUser WHERE adminUserId = '" + adminuserId + "'";
		AdminUserDTO dto = null;
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<AdminUserDTO>(AdminUserDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	// 관리자 아이디 수정
	public void adminUserUpdate(String adminUserNum, String adminUserName, String adminUserId, String adminUserPwd,
			int adminUserBanner, int adminUserCustomer, int adminUserProduct, int adminUserOrder, String id) {
		String sql="UPDATE adminUser SET adminUserNum='" + adminUserNum + "',"
				+"adminUserName='" + adminUserName + "',"
				+"adminUserId='" + adminUserId + "',"
				+"adminUserPwd='" + adminUserPwd + "',"
				+"adminUserBanner=" + adminUserBanner + ","
				+"adminUserCustomer=" + adminUserCustomer + ","
				+"adminUserProduct=" + adminUserProduct + ","
				+"adminUserOrder=" + adminUserOrder 
				+ " WHERE adminUserId='"+id+"'";
		try {
			template.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 관리자 아이디 삭제
	public void adminUserDelete(String adminUserDelete) {
		String sql = "DELETE FROM adminUser WHERE adminUserId='" + adminUserDelete + "'";
		
		template.update(sql);
	}
	// 관리자 아이디 생성
	public void adminUserAdd(int adminUserNum, String adminUserName, String adminUserId, String adminUserPwd,
			int adminUserBanner, int adminUserCustomer, int adminUserProduct, int adminUserOrder) {
		String sql="INSERT INTO adminUser VALUES ("+ adminUserNum + ","
				+"'" + adminUserName + "',"
				+"'" + adminUserId + "',"
				+"'" + adminUserPwd + "',"
				+ adminUserBanner + ","
				+ adminUserCustomer + ","
				+ adminUserProduct + ","
				+ adminUserOrder+",0)";
		try {
			template.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 중복 확인
	public int overlapCheck(String adminUser, String adminUserdata) {
		String sql="SELECT COUNT(*) FROM adminUser WHERE "+adminUser+" = '"+adminUserdata+"'";
		try {
			return template.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}
	
	// 등록된 아이디인지 확인
	public int adminUserLogin(String adminuserId) {
		String sql = "SELECT COUNT(*) FROM adminUser WHERE adminUserId='" + adminuserId + "'";
		try {
			return template.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}
}