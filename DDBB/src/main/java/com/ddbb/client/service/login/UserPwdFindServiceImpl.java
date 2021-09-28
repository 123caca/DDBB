package com.ddbb.client.service.login;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ddbb.client.DAO.UserDAO;
import com.ddbb.client.DTO.UserDTO;
@Service
public class UserPwdFindServiceImpl implements LoginService {
	@Autowired
	private UserDAO userdao;
	@Override
	public void execute(Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest re=(HttpServletRequest)map.get("request");
		String userId=(String)re.getParameter("id");
		String userName=(String)re.getParameter("name");
		String userPhone=(String)re.getParameter("phone1")+"-"+(String)re.getParameter("phone2")
		+"-"+(String)re.getParameter("phone3");
		
		if(userId!=null) {
			UserDTO userDTO=userdao.userPwdFind(userId,userName,userPhone);
			if(userDTO!=null) {
				model.addAttribute("userDTO",userDTO);
			}
		}
	}

}
