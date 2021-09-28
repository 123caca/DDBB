package com.ddbb.admin.service.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.admin.DAO.AdminUserDAO;
import com.ddbb.admin.DTO.AdminUserDTO;
@Service
public class adminLoginServiceImpl implements LoginService{
	@Autowired
	private AdminUserDAO adminuserdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		HttpSession session = re.getSession();
		String adminuserId=(String)re.getParameter("id");
		String adminuserPwd=(String)re.getParameter("pwd");
		
		if(adminuserId==null || adminuserId.equals("")) {
			model.addAttribute("adminUserLogin","아이디를 입력해주세요");
		}else if(adminuserPwd==null || adminuserPwd.equals("")) {
			model.addAttribute("adminUserLogin","비밀번호를를 입력해주세요");
		}else {
			if(adminuserdao.adminUserLogin(adminuserId)==0) {
				model.addAttribute("adminUserLogin","없는 아이디입니다.");
			}else {
				AdminUserDTO adminuserDTO=adminuserdao.adminUserLogin(adminuserId,adminuserPwd);
				if(adminuserDTO!=null) {
					session.setAttribute("adminuser", adminuserDTO);
				} else {
					model.addAttribute("adminUserLogin","비밀번호가 다릅니다.");
				}
			}
		}
	}

}
