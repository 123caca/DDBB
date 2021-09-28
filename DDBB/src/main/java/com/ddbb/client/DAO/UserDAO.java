package com.ddbb.client.DAO;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ddbb.client.DTO.UserDTO;

@Repository
public class UserDAO {
	private JdbcTemplate template;

	public UserDAO(JdbcTemplate template) {
		this.template = template;
	}

	// 아이디 중복 확인
	public int idCheck(String userId) {
		String sql = "SELECT COUNT(*) FROM userInfo WHERE userId='" + userId + "'";
		try {
			return template.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 회원가입(userInfo 테이블 데이터 추가)
	public void userJoin(final String userId, final String userPwd, final String userName, final String userEmail,
			final String userPhone, final String userAddress) {
		String sql = "INSERT INTO userInfo VALUES ('" + userId + "','" + userPwd + "','" + userName + "','" + userEmail
				+ "','" + userPhone + "','" + userAddress + "',TO_char(SYSDATE, 'yyyy-mm-dd'))";
		try {
			template.update(sql);
		} catch (Exception e) {e.printStackTrace();}
	}

	// 로그인 ( 아이디, 비밀번호 )
	public UserDTO userLogin(String userId, String userPwd) {
		String sql = "SELECT * FROM userInfo WHERE userId = '" + userId + "' and userPwd='" + userPwd + "'";
		UserDTO dto = null;
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {e.printStackTrace();}
		return dto;
	}

	// 로그인 ( 아이디 여부 확인 )
	public int userLogin(String userId) {
		String sql = "SELECT COUNT(*) FROM userInfo WHERE userId='" + userId + "'";
		try {
			return template.queryForObject(sql, Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 아이디 찾기
	public UserDTO userIDFind(String userName, String userPhone) {
		String sql = "SELECT * FROM userInfo WHERE userName ='" + userName + "' and userPhone='" + userPhone + "'";
		UserDTO dto = null;
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {e.printStackTrace();}
		return dto;
	}

	// 비밀번호 찾기
	public UserDTO userPwdFind(String userId, String userName, String userPhone) {
		String sql = "SELECT * FROM userInfo WHERE userId='" + userId + "' and userName ='" + userName
				+ "' and userPhone='" + userPhone + "'";
		UserDTO dto = null;
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {e.printStackTrace();}
		return dto;
	}

	// 비밀번호 찾기 후 비밀번호 변경
	public void userPwdUpdate(String userId, String userPwd) {
		String sql = "UPDATE userInfo SET userPwd='" + userPwd + "' WHERE userId='" + userId + "'";
		try {
			template.update(sql);
		} catch (Exception e) {e.printStackTrace();}
	}

	// 자동 로그인
	public UserDTO autologin(String userID) {
		String sql = "SELECT * FROM userInfo WHERE userId = '" + userID + "'";
		UserDTO dto = null;
		try {
			dto = template.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (Exception e) {	}
		return dto;
	}

	// 회원 정보 수정
	public void userModify(String userId, String userPwd, String userName, String userEmail, String userPhone,
			String userAddress) {
		String sql = "UPDATE userInfo SET userName='" + userName + "'," + "userPwd='" + userPwd + "'," + "userEmail='"
				+ userEmail + "'," + "userPhone='" + userPhone + "'," + "userAddress='" + userAddress
				+ "' WHERE UserId='" + userId + "'";
		try {
			template.update(sql);
		} catch (Exception e) {e.printStackTrace();}
	}

	// 회원 삭제
	public void userDelete(String userId) {
		String sql = "DELETE FROM userInfo WHERE userId='" + userId + "'";
		try {
			template.update(sql);
		} catch (Exception e) {e.printStackTrace();}
	}
}
