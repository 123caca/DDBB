package com.ddbb.client.service.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.UserDAO;
import com.ddbb.client.DTO.UserDTO;
@Service
public class UserLoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		String userId=(String)re.getParameter("id");
		String userPwd=(String)re.getParameter("pwd");
		if(userId==null || userId.equals("")) {
			model.addAttribute("userLogin","아이디를 입력해주세요");
		}else if(userPwd==null || userPwd.equals("")) {
			model.addAttribute("userLogin","비밀번호를를 입력해주세요");
		}else {
			if(userdao.userLogin(userId)==0) {
				model.addAttribute("userLogin","존재하지 않는 아이디입니다.");
			}else {
				UserDTO userDTO=userdao.userLogin(userId,userPwd);
				if(userDTO!=null) {
					session.setAttribute("user", userDTO);
				} else {
					model.addAttribute("userLogin","비밀번호가 일치하지 않습니다.");
				}
			}
		}
		
		
	}

}
